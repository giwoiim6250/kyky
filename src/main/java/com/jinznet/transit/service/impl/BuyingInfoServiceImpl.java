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
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jinznet.transit.controller.entity.BuyingInfo;
import com.jinznet.transit.controller.entity.Pagination;
import com.jinznet.transit.enumeration.Order;
import com.jinznet.transit.service.BuyingInfoService;

@Service
public class BuyingInfoServiceImpl implements BuyingInfoService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BuyingInfo save(final BuyingInfo buyingInfo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		final String sql = "insert into Buying_Info(username,address_province,address_city,address_district,sex,birthday,"
				+ "telephone,car_model,mileage,buy_date,storeAddress,business_username,business_telephone,"
				+ "info_type,picture,story,praise_num,purchase_num,create_time,description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, buyingInfo.getUsername());
				ps.setString(2, buyingInfo.getAddressProvince());
				ps.setString(3, buyingInfo.getAddressCity());
				ps.setString(4, buyingInfo.getAddressDistrict());
				ps.setInt(5, buyingInfo.getSex());
				if(buyingInfo.getBirthday() != null){
					ps.setDate(6, new Date(buyingInfo.getBirthday().getTime()));
				}else{
					ps.setDate(6, null);
				}
				ps.setString(7, buyingInfo.getTelephone());
				ps.setInt(8, buyingInfo.getCarModel());
				ps.setInt(9, buyingInfo.getMileage());
				if(buyingInfo.getBuyDate() != null){
					ps.setDate(10, new Date(buyingInfo.getBuyDate().getTime()));
				}else{
					ps.setDate(10, null);
				}
				ps.setString(11, buyingInfo.getStoreAddress());
				ps.setString(12, buyingInfo.getBusinessUsername());
				ps.setString(13, buyingInfo.getBusinesseTelephone());
				ps.setInt(14, buyingInfo.getInfoType());
				ps.setString(15, buyingInfo.getPicture());
				ps.setString(16, buyingInfo.getStory());
				ps.setInt(17, buyingInfo.getPraiseNum());
				ps.setInt(18, buyingInfo.getPurchaseNum());
				if(buyingInfo.getCreateTime() != null){
					ps.setDate(19, new Date(buyingInfo.getCreateTime().getTime()));
				}else{
					ps.setDate(19, new Date(new java.util.Date().getTime()));
				}
				ps.setString(20, buyingInfo.getDescription());
				return ps;
			}
		}, keyHolder);

		buyingInfo.setId(keyHolder.getKey().intValue());
		return buyingInfo;
	}

	@Override
	public BuyingInfo queryById(final int id) {
		String sql = "select * from Buying_Info where picture is not null and status = 1 and id = " + id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<BuyingInfo>(){

			@Override
			public BuyingInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
				BuyingInfo buyingInfo = null;
				if(rs.next()){
					buyingInfo = new BuyingInfo();
					buyingInfo.setId(id);
					buyingInfo.setUsername(rs.getString(2));
					buyingInfo.setAddressProvince(rs.getString(3));
					buyingInfo.setAddressCity(rs.getString(4));
					buyingInfo.setAddressDistrict(rs.getString(5));
					buyingInfo.setSex(rs.getInt(6));
					if(rs.getDate(7) != null){
						buyingInfo.setBirthday(new Date(rs.getDate(7).getTime()));
					}
					buyingInfo.setTelephone(rs.getString(8));
					buyingInfo.setCarModel(rs.getInt(9));
					buyingInfo.setMileage(rs.getInt(10));
					if(rs.getDate(11) != null){
						buyingInfo.setBuyDate(new Date(rs.getDate(11).getTime()));
					}
					buyingInfo.setStoreAddress(rs.getString(12));
					buyingInfo.setBusinessUsername(rs.getString(13));
					buyingInfo.setBusinesseTelephone(rs.getString(14));
					buyingInfo.setInfoType(rs.getInt(15));
					buyingInfo.setPicture(rs.getString(16));
					buyingInfo.setStory(rs.getString(17));
					buyingInfo.setPraiseNum(rs.getInt(18));
					buyingInfo.setPurchaseNum(rs.getInt(19));
					if(rs.getDate(20) != null){
						buyingInfo.setCreateTime(new Date(rs.getDate(20).getTime()));
					}
					buyingInfo.setDescription(rs.getString(21));
				}
				return buyingInfo;
			}
			
		});
	}
	
	/* (non-Javadoc)
	 * @see com.jinznet.transit.service.BuyingInfoService#queryAll()
	 */
	@Override
	public List<BuyingInfo> queryAll() {
		final List<BuyingInfo> buyingInfos = new ArrayList<BuyingInfo>();
		String sql = "select * from Buying_Info";
		jdbcTemplate.query(sql, new ResultSetExtractor<BuyingInfo>(){

			@Override
			public BuyingInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
				BuyingInfo buyingInfo = null;
				while(rs.next()){
					buyingInfo = new BuyingInfo();
					buyingInfo.setId(rs.getInt(1));
					buyingInfo.setUsername(rs.getString(2));
					buyingInfo.setAddressProvince(rs.getString(3));
					buyingInfo.setAddressCity(rs.getString(4));
					buyingInfo.setAddressDistrict(rs.getString(5));
					buyingInfo.setSex(rs.getInt(6));
					if(rs.getDate(7) != null){
						buyingInfo.setBirthday(new Date(rs.getDate(7).getTime()));
					}
					buyingInfo.setTelephone(rs.getString(8));
					buyingInfo.setCarModel(rs.getInt(9));
					buyingInfo.setMileage(rs.getInt(10));
					if(rs.getDate(11) != null){
						buyingInfo.setBuyDate(new Date(rs.getDate(11).getTime()));
					}
					buyingInfo.setStoreAddress(rs.getString(12));
					buyingInfo.setBusinessUsername(rs.getString(13));
					buyingInfo.setBusinesseTelephone(rs.getString(14));
					buyingInfo.setInfoType(rs.getInt(15));
					buyingInfo.setPicture(rs.getString(16));
					buyingInfo.setStory(rs.getString(17));
					buyingInfo.setPraiseNum(rs.getInt(18));
					buyingInfo.setPurchaseNum(rs.getInt(19));
					if(rs.getDate(20) != null){
						buyingInfo.setCreateTime(new Date(rs.getDate(20).getTime()));
					}
					buyingInfo.setDescription(rs.getString(21));
					buyingInfos.add(buyingInfo);
				}
				return null;
			}
			
		});
		return buyingInfos;
	}

	@Override
	public List<BuyingInfo> queryByName(String content, Pagination pagination, Order order) {
		if(StringUtils.isEmpty(content)){
			return queryByPagination(pagination, order);
		}
		final List<BuyingInfo> buyingInfos = new ArrayList<BuyingInfo>();
		int offset = (pagination.getCurrent() - 1) * pagination.getPageSize();
		StringBuilder builder = new StringBuilder("select * from Buying_Info where picture is not null and status = 1 and id like '%");
		builder.append(content).append("%'").append(" OR username like '%").append(content).append("%'");
		builder.append(" order by ");
		builder.append(order.getField()).append(" ").append(order.getType());
		builder.append(" limit ").append(offset).append(",").append(pagination.getPageSize());
		jdbcTemplate.query(builder.toString(), new ResultSetExtractor<BuyingInfo>(){

			@Override
			public BuyingInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()){
					BuyingInfo buyingInfo = new BuyingInfo();
					buyingInfo.setId(rs.getInt(1));
					buyingInfo.setUsername(rs.getString(2));
					buyingInfo.setAddressProvince(rs.getString(3));
					buyingInfo.setAddressCity(rs.getString(4));
					buyingInfo.setAddressDistrict(rs.getString(5));
					buyingInfo.setSex(rs.getInt(6));
					if(rs.getDate(7) != null){
						buyingInfo.setBirthday(new Date(rs.getDate(7).getTime()));
					}
					buyingInfo.setTelephone(rs.getString(8));
					buyingInfo.setCarModel(rs.getInt(9));
					buyingInfo.setMileage(rs.getInt(10));
					if(rs.getDate(11) != null){
						buyingInfo.setBuyDate(new Date(rs.getDate(11).getTime()));
					}
					buyingInfo.setStoreAddress(rs.getString(12));
					buyingInfo.setBusinessUsername(rs.getString(13));
					buyingInfo.setBusinesseTelephone(rs.getString(14));
					buyingInfo.setInfoType(rs.getInt(15));
					buyingInfo.setPicture(rs.getString(16));
					buyingInfo.setStory(rs.getString(17));
					buyingInfo.setPraiseNum(rs.getInt(18));
					buyingInfo.setPurchaseNum(rs.getInt(19));
					if(rs.getDate(20) != null){
						buyingInfo.setCreateTime(new Date(rs.getDate(20).getTime()));
					}
					buyingInfo.setDescription(rs.getString(21));
					buyingInfos.add(buyingInfo);
				}
				return null;
			}
			
		});
		return buyingInfos;
	}

	@Override
	public List<BuyingInfo> queryByPagination(Pagination pagination, Order order) {
		final List<BuyingInfo> buyingInfos = new ArrayList<BuyingInfo>();
		int start = (pagination.getCurrent() - 1) * pagination.getPageSize();
		StringBuilder builder = new StringBuilder("select * from Buying_Info where picture is not null and status = 1 order by ");
		builder.append(order.getField()).append(" ").append(order.getType());
		builder.append(" limit ").append(start).append(",").append(pagination.getPageSize());
		jdbcTemplate.query(builder.toString(), new ResultSetExtractor<BuyingInfo>(){

			@Override
			public BuyingInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()){
					BuyingInfo buyingInfo = new BuyingInfo();
					buyingInfo.setId(rs.getInt(1));
					buyingInfo.setUsername(rs.getString(2));
					buyingInfo.setAddressProvince(rs.getString(3));
					buyingInfo.setAddressCity(rs.getString(4));
					buyingInfo.setAddressDistrict(rs.getString(5));
					buyingInfo.setSex(rs.getInt(6));
					if(rs.getDate(7) != null){
						buyingInfo.setBirthday(new Date(rs.getDate(7).getTime()));
					}
					buyingInfo.setTelephone(rs.getString(8));
					buyingInfo.setCarModel(rs.getInt(9));
					buyingInfo.setMileage(rs.getInt(10));
					if(rs.getDate(11) != null){
						buyingInfo.setBuyDate(new Date(rs.getDate(11).getTime()));
					}
					buyingInfo.setStoreAddress(rs.getString(12));
					buyingInfo.setBusinessUsername(rs.getString(13));
					buyingInfo.setBusinesseTelephone(rs.getString(14));
					buyingInfo.setInfoType(rs.getInt(15));
					buyingInfo.setPicture(rs.getString(16));
					buyingInfo.setStory(rs.getString(17));
					buyingInfo.setPraiseNum(rs.getInt(18));
					buyingInfo.setPurchaseNum(rs.getInt(19));
					if(rs.getDate(20) != null){
						buyingInfo.setCreateTime(new Date(rs.getDate(20).getTime()));
					}
					buyingInfo.setDescription(rs.getString(21));
					buyingInfos.add(buyingInfo);
				}
				return null;
			}
			
		});
		return buyingInfos;
	}

	@Override
	public BuyingInfo updatePraiseNum(int id, int num) {
		String sql = "update buying_Info set praise_num = praise_num + 1 where id = " + id;
		jdbcTemplate.update(sql);
		return queryById(id);
	}

	@Override
	public BuyingInfo updatePicture(BuyingInfo buyingInfo) {
		StringBuilder builder = new StringBuilder("update buying_Info set picture = '");
		builder.append(buyingInfo.getPicture()).append("' , story = '").append(buyingInfo.getStory());
		builder.append("' where id = ").append(buyingInfo.getId());
		jdbcTemplate.update(builder.toString());
		return queryById(buyingInfo.getId());
	}

	public static void main(String[] args) {
		BuyingInfo buyingInfo = new BuyingInfo();
		buyingInfo.setId(11);
		buyingInfo.setStory("sfdsfsdf");
		buyingInfo.setPicture("/sfdfd/a.jpg");
		StringBuilder builder = new StringBuilder("update buying_Info set picture = '");
		builder.append(buyingInfo.getPicture()).append("' , story = '").append(buyingInfo.getStory());
		builder.append("' where id = ").append(buyingInfo.getId());
		System.out.println(builder.toString());
	}

	/* (non-Javadoc)
	 * @see com.jinznet.transit.service.BuyingInfoService#count(java.lang.String)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public int count(String content) {
		StringBuilder builder = new StringBuilder("select count(1) from Buying_Info where picture is not null and status = 1");
		if(!StringUtils.isEmpty(content)){
			builder.append(" and id like '%");
			builder.append(content).append("%'").append(" OR username like '%").append(content).append("%'");
		}
		return this.jdbcTemplate.queryForInt(builder.toString());
	}
}
