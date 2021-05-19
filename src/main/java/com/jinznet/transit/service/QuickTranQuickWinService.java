/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: QuickTranQuickWinService.java
 * Author:   raolesong
 * Date:     2018年8月18日 上午10:45:09
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.jinznet.transit.service;

import java.util.List;

import com.jinznet.transit.controller.entity.CarOwner;
import com.jinznet.transit.controller.entity.SaleMsg;
import com.jinznet.transit.controller.entity.SalePrize;

/**
 * 快运快赢服务
 * 2018年8月18日 上午10:45:09
 */
public interface QuickTranQuickWinService {

	//车主报名
	public CarOwner saveCarOwnerInfo(CarOwner vo);
	
	//销售报名
	public SaleMsg saveSaleMsg(SaleMsg vo);
	
	//销售中奖
	public SalePrize saveSalePrize(SalePrize vo);
	
	//更新销售中奖次数--第7次
	public SalePrize updateSalePrizeCount(String openId,int prizeCount);
		
	//查询销售中奖
	public List<SalePrize> getSalePrizeList(String openId,String prizeDes,String name);
	
	//中奖
	public boolean doLuckPrize();
	
}
