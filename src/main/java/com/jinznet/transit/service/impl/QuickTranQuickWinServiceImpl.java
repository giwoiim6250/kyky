/*
 * Copyright (C), 2013-2018, 上汽集团
 * FileName: QuickTranQuickWinServiceImpl.java
 * Author:   raolesong
 * Date:     2018年8月18日 上午10:51:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.jinznet.transit.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.StringUtils;

import com.jinznet.transit.controller.entity.BuyingInfo;
import com.jinznet.transit.controller.entity.CarOwner;
import com.jinznet.transit.controller.entity.SaleMsg;
import com.jinznet.transit.controller.entity.SalePrize;
import com.jinznet.transit.service.QuickTranQuickWinService;

import freemarker.template.utility.StringUtil;

/**
 * 2018年8月18日 上午10:51:44
 */
public class QuickTranQuickWinServiceImpl implements QuickTranQuickWinService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public CarOwner saveCarOwnerInfo(final CarOwner vo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		final String sql = "insert into t_car_owner(open_id,name,phone,vin,buy_car_time,create_time) values(?,?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, vo.getOpenId());
				ps.setString(2, vo.getName());
				ps.setString(3, vo.getPhone());
				ps.setString(4, vo.getVin());
				ps.setDate(5, new Date(vo.getBuyCarTime().getTime()));
				ps.setDate(6, new Date(new java.util.Date().getTime()));
				return ps;
			}
		}, keyHolder);

		vo.setId(keyHolder.getKey().intValue());
		return vo;
	}

	@Override
	public SaleMsg saveSaleMsg(final SaleMsg vo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		final String sql = "insert into t_sale_msg(open_id,store_name,store_province,store_city,sale_name,sale_phone,"
				+ "recommend_car_name,recommend_car_phone,recommend_car_vin,creat_time) values(?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, vo.getOpenId());
				ps.setString(2, vo.getStoreName());
				ps.setString(3, vo.getStoreProvince());
				ps.setString(4, vo.getStoreCity());
				ps.setString(5, vo.getSaleName());
				ps.setString(6, vo.getSalePhone());
				ps.setString(7, vo.getRecommendCarName());
				ps.setString(8, vo.getRecommendCarPhone());
				ps.setString(9, vo.getRecommendCarVin());
				ps.setDate(10, new Date(new java.util.Date().getTime()));
				return ps;
			}
		}, keyHolder);

		vo.setId(keyHolder.getKey().intValue());
		return vo;
	}

	@Override
	public SalePrize saveSalePrize(final SalePrize vo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		final String sql = "insert into t_sale_prize(sale_open_id,sale_name,store_name,prize_des,recommend_count,creat_time) values(?,?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, vo.getSaleOpenId());
				ps.setString(2, vo.getSaleName());
				ps.setString(3, vo.getStoreName());
				ps.setString(4, vo.getPrizeDes());
				ps.setInt(5, vo.getRecommendCount());
				ps.setDate(6, new Date(new java.util.Date().getTime()));
				return ps;
			}
		}, keyHolder);

		vo.setId(keyHolder.getKey().intValue());
		return vo;
	}

	@Override
	public SalePrize updateSalePrizeCount(String openId, int prizeCount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<SalePrize> getSalePrizeList(String openId,String des,String name) {
		final List<SalePrize> salePrizeList = new ArrayList<SalePrize>();
		StringBuffer sql = new StringBuffer("select * from t_sale_prize where 1=1 ");
		if(StringUtils.isEmpty(openId)){
			sql.append(" and sale_open_id='"+openId+"'");
		}
		if(StringUtils.isEmpty(des)){
			sql.append(" and prize_des='"+des+"'");
		}
		if(StringUtils.isEmpty(name)){
			sql.append(" and sale_name like '%"+name+"%'");
		}
		
		jdbcTemplate.query(sql.toString(), new ResultSetExtractor<Object>(){

			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				SalePrize vo = null;
				while(rs.next()){
					vo = new SalePrize();
					vo.setId(rs.getInt(1));
					vo.setSaleOpenId(rs.getString(2));
					vo.setSaleName(rs.getString(3));
					vo.setStoreName(rs.getString(4));
					vo.setPrizeDes(rs.getString(5));
					vo.setRecommendCount(rs.getInt(6));
					salePrizeList.add(vo);
				}
				return null;
			}
			
		});
		return salePrizeList;
	}

	@Override
	public boolean doLuckPrize() {
		
		final String sql = "update t_prize_item set available_num=available_num-1,use_num=use_num+1 where id= 1 and available_num>0";
				
		int result = jdbcTemplate.update(sql);
		
		if(result>0){
			SalePrize vo = new SalePrize();
			saveSalePrize(vo);
			return true;
		}

		return false;
	}

}
