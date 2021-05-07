package com.jinznet.transit.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jinznet.transit.controller.entity.BuyingInfo;
import com.jinznet.transit.controller.entity.Pagination;
import com.jinznet.transit.enumeration.Order;
import com.jinznet.transit.service.BuyingInfoService;

@RestController
public class InfoListsController {

	@Resource
	private BuyingInfoService buyingInfoService;
	
	@RequestMapping("/list")
	public ModelAndView queryByNamePagination(@RequestParam(value = "content",required = false) String content,@RequestParam(value = "current",defaultValue = "1") int current, 
			@RequestParam(value = "pageSize",defaultValue = "6") int pageSize,@RequestParam(value = "type",defaultValue="0") int type){
		Pagination pagination = new Pagination(pageSize, current);
		Order order = Order.CREATE_TIME_ASC;
		//点赞排序
		if(type == 1){
			order = Order.PRAISE_DESC;
		}
		List<BuyingInfo> buyingInfos = this.buyingInfoService.queryByName(content, pagination, order);
		int totalRows = buyingInfoService.count(content);
		int pageCount = 0;
		if(totalRows > 0){
			pageCount = (totalRows - 1)/pageSize + 1;
		}
		return new ModelAndView("list.ftl").addObject("buyingInfos", buyingInfos)
				.addObject("searchContent", content).addObject("pageCount", pageCount)
				.addObject("sortType", type).addObject("now", new Date());
	}
	
	@RequestMapping("/list/more")
	public ModelAndView queryByMore(@RequestParam(value = "content",required = false) String content,@RequestParam(value = "current",defaultValue = "1") int current, 
			@RequestParam(value = "pageSize",defaultValue = "6") int pageSize,@RequestParam(value = "type",defaultValue="0") int type){
		Pagination pagination = new Pagination(pageSize, current);
		Order order = Order.CREATE_TIME_ASC;
		//点赞排序
		if(type == 1){
			order = Order.PRAISE_DESC;
		}
		List<BuyingInfo> buyingInfos = this.buyingInfoService.queryByName(content, pagination, order);
		return new ModelAndView("list-data.ftl").addObject("buyingInfos", buyingInfos).addObject("searchContent", content);
	}
	
}
