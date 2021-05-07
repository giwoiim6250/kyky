package com.jinznet.transit.service;

import java.util.List;

import com.jinznet.transit.controller.entity.BuyingInfo;
import com.jinznet.transit.controller.entity.Pagination;
import com.jinznet.transit.enumeration.Order;

public interface BuyingInfoService {
	
	public BuyingInfo save(BuyingInfo buyingInfo);

	public BuyingInfo queryById(int id);
	
	public List<BuyingInfo> queryAll();
	
	public List<BuyingInfo> queryByName(String content, Pagination pagination, Order order);
	
	public List<BuyingInfo> queryByPagination(Pagination pagination,Order order);
	
	public BuyingInfo updatePraiseNum(int id, int num);
	
	public BuyingInfo updatePicture(BuyingInfo buyingInfo);
	
	/**总共数目*/
	public int count(String content);
}
