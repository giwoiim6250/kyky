package com.jinznet.transit.controller;

import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jinznet.transit.controller.entity.BuyingInfo;
import com.jinznet.transit.service.BuyingInfoService;
import com.jinznet.transit.util.ClientIPUtil;
import com.jinznet.transit.util.IPAccessCache;

@RestController
public class BuyingInfoController {
	
	private static long ONE_DAY_SECONDS = 24*60*60*1000;

	@Resource
	private BuyingInfoService buyingInfoService;
	
	@RequestMapping("/buying/save")
	public ModelAndView save(BuyingInfo buyingInfo){
		buyingInfo.setCreateTime(new Date());
		BuyingInfo info = buyingInfoService.save(buyingInfo);
		return new ModelAndView("redirect:/upload/index.htm").addObject("id", info.getId());
	}
	
	@RequestMapping("/buying/update/{id}")
	public BuyingInfo updatePraiseNum(@PathVariable int id){
		return this.buyingInfoService.updatePraiseNum(id, 1);
	}
	
	@RequestMapping("/buying/update/picture")
	public ModelAndView updatePicture(BuyingInfo buyingInfo){
		BuyingInfo info = this.buyingInfoService.updatePicture(buyingInfo);
		return new ModelAndView("upload-success.ftl").addObject("info", info);
	}
	
	@RequestMapping("/rule")
	public ModelAndView rule(@RequestParam(value = "infoType",defaultValue="1") int infoType){
		ModelAndView view = new ModelAndView("/rule-dealer.ftl");
		if(infoType == 2){
			view =  new ModelAndView("/rule-owner.ftl");
		}
		view.addObject("infoType", infoType);
		return view;
	}
	
	@RequestMapping("/buying/index")
	public ModelAndView index(@RequestParam(value = "infoType",defaultValue="1") int infoType){
		ModelAndView view = null;
		
		if(infoType == 1){
			view = new ModelAndView("form-dealer.ftl");
		}else if(infoType == 2){
			view = new ModelAndView("form-owner.ftl");
		}
		view.addObject("infoType", infoType);
		
		return view;
	}
	
	@RequestMapping("/praise")
	public int praise(@RequestParam(value = "id") int id,HttpServletRequest request){
		String ip = ClientIPUtil.getIp(request);
		boolean doPraise = true;
		if(!StringUtils.isEmpty(ip)){
			if(IPAccessCache.cache.containsKey(id) && IPAccessCache.cache.get(id).containsKey(ip)){
				DateTime now = new DateTime();
				Date lastUpdateDate = IPAccessCache.cache.get(id).get(ip);
				long milliseconds = (now.getMillis() - lastUpdateDate.getTime());
				//说明24小时之内点过
				if(milliseconds < ONE_DAY_SECONDS){
					doPraise = false;
				}
			}
		}
		int praiseNum = 0;
		BuyingInfo buyingInfo = null;
		if(doPraise){
			buyingInfo = this.buyingInfoService.updatePraiseNum(id, 1);
			if(!IPAccessCache.cache.containsKey(id)){
				HashMap<String, Date> value = new HashMap<String, Date>();
				value.put(ip, new Date());
				IPAccessCache.cache.put(id, value);
			}else{
				IPAccessCache.cache.get(id).put(ip, new Date());
			}
		}else{
			praiseNum = -1;
		}
		if(buyingInfo != null){
			praiseNum = buyingInfo.getPraiseNum();
		}
		return praiseNum;
		
	}
	
	@RequestMapping("/votes")
	public ModelAndView votes(){
		return new ModelAndView("award-list.ftl");
	}
	
}
