/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: QuickTranQuickWinController.java
 * Author:   raolesong
 * Date:     2018年8月18日 上午10:53:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.jinznet.transit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jinznet.transit.controller.entity.CarOwner;
import com.jinznet.transit.controller.entity.SaleMsg;
import com.jinznet.transit.controller.entity.SalePrize;
import com.jinznet.transit.service.QuickTranQuickWinService;

/**
 * 快运快赢
 * 2018年8月18日 上午10:53:35
 */
@RestController
@RequestMapping("/quickTranQuickWin")
public class QuickTranQuickWinController {
	
	private static String jdTicket100 = "100";
	
	private static String jdTicket200 = "200";
	
	private static HashMap<Integer,Integer> luckRuleMap = new HashMap<Integer,Integer>();
	
	static{
		luckRuleMap.put(3, 30);
		luckRuleMap.put(4, 30);
		luckRuleMap.put(5, 100);
		luckRuleMap.put(6, 100);
	}
	
	
	@Resource
	private QuickTranQuickWinService quickTranQuickWinService;
	
	@RequestMapping("/saveCarOwner")
	public ModelAndView save(CarOwner vo){
		quickTranQuickWinService.saveCarOwnerInfo(vo);
		return null;
//		return new ModelAndView("redirect:/upload/index.htm").addObject("id", info.getId());
	}
	
	@RequestMapping("/saveSaleMsg")
	public ModelAndView save(SaleMsg vo){
		quickTranQuickWinService.saveSaleMsg(vo);
		return null;
//		return new ModelAndView("redirect:/upload/index.htm").addObject("id", info.getId());
	}
	
	
	@RequestMapping("/salePrize")
	public ModelAndView save(){
		SalePrize vo = new SalePrize();
		quickTranQuickWinService.saveSalePrize(vo);
		return null;
//		return new ModelAndView("redirect:/upload/index.htm").addObject("id", info.getId());
	}
	
	
	@RequestMapping("/getSalePrizeList")
	public ModelAndView getSalePrizeList(String name){
		List<SalePrize> list = quickTranQuickWinService.getSalePrizeList(null,null,name);
		return null;
//		return new ModelAndView("redirect:/upload/index.htm").addObject("id", info.getId());
	}
	
	//抽奖
	private boolean tryLuck(String openId){
		int luckIndex = 4; 
		String des = "";
		if(luckIndex<=5){
			des = jdTicket100;
		}else{
			des = jdTicket200;
		}
		
		List<SalePrize> list = quickTranQuickWinService.getSalePrizeList(openId,des,null);
		if(list!=null){
			return false;
		}
		//抽奖算法
		boolean result = getPrizeChance(luckRuleMap.get(luckIndex));
		if(result){
			if(quickTranQuickWinService.doLuckPrize()){
				
			}else{
				//奖抽完
			}
		}else{
			//抱歉，没中
		}
		
		return false;
	}
	
	//获取中奖机会
	private boolean getPrizeChance(int seed){
		Random random = new Random();
		int r = random.nextInt(100);
		if(r<=seed){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		QuickTranQuickWinController c = new QuickTranQuickWinController();
		System.out.println(c.getPrizeChance(1));
	}

}
