package com.jinznet.transit.controller;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jinznet.transit.controller.entity.BuyingInfo;
import com.jinznet.transit.exception.BaseException;
import com.jinznet.transit.service.BuyingInfoService;

@RestController
@RequestMapping("/detail")
public class InfoDetailController {

	@Resource
	private BuyingInfoService buyingInfoService;
	
	@RequestMapping("{id}")
	public ModelAndView queryById(@PathVariable int id){
		BuyingInfo info = this.buyingInfoService.queryById(id);
		DateTime now = new DateTime();
		if(info == null){
			throw new BaseException("访问的id : " + id + "不存在");
		}
		int age = 1;
		try {
			age = (now.getYear() - new DateTime(info.getBirthday().getTime()).getYear()) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("detail.ftl").addObject("info", info).addObject("age", age);
	}
	
}
