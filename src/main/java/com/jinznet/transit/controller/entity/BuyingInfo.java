package com.jinznet.transit.controller.entity;

import java.util.Date;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jinznet.transit.excel.annotation.ExportTitle;

@Table(name="Buying_Info")
public class BuyingInfo {

	@ExportTitle("id")
	private int id;
	
	@ExportTitle("姓名")
	private String username;
	
	@ExportTitle("省")
	private String addressProvince;
	
	@ExportTitle("市")
	private String addressCity;
	
	@ExportTitle("区")
	private String addressDistrict;
	
	//1男，2女
	@ExportTitle("性别(1男 2女)")
	private int sex;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@ExportTitle("生日")
	private Date birthday;
	
	@ExportTitle("电话")
	private String telephone;
	
	//车型1经典  2新世代
	@ExportTitle("车型(1经典 2新世代)")
	private int carModel;
	
	//里程
	@ExportTitle("里程数")
	private int mileage;
	
	//购买日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@ExportTitle("购买日期")
	private Date buyDate;
	
	//4S店
	@ExportTitle("经销商")
	private String storeAddress;
	
	//业务员姓名
	@ExportTitle("业务员姓名")
	private String businessUsername;
	
	//业务员电话
	@ExportTitle("业务员电话")
	private String businesseTelephone;
	
	//线索类型 1经销商2车主
	@ExportTitle("线索(1经销商 2车主)")
	private int infoType;
	
	//个人照片
	@ExportTitle("照片")
	private String picture;
	
	//分享故事内容
	@ExportTitle("故事")
	private String story;
	
	//点赞数量
	@ExportTitle("点赞数目")
	private int praiseNum;
	
	//购买数量
	@ExportTitle("购买数量")
	private int purchaseNum;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@ExportTitle("创建时间")
	private Date createTime;
	
	@ExportTitle("描述")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddressProvince() {
		return addressProvince;
	}

	public void setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressDistrict() {
		return addressDistrict;
	}

	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getCarModel() {
		return carModel;
	}

	public void setCarModel(int carModel) {
		this.carModel = carModel;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getBusinessUsername() {
		return businessUsername;
	}

	public void setBusinessUsername(String businessUsername) {
		this.businessUsername = businessUsername;
	}

	public String getBusinesseTelephone() {
		return businesseTelephone;
	}

	public void setBusinesseTelephone(String businesseTelephone) {
		this.businesseTelephone = businesseTelephone;
	}

	public int getInfoType() {
		return infoType;
	}

	public void setInfoType(int infoType) {
		this.infoType = infoType;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public int getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
