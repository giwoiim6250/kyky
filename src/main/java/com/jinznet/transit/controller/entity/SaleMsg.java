/******************************************************************
** 标    题：BuyingInfoEntity
** 创 建 者：bianj
** 创建日期：2018-08-18 10:42:00
** 描    述：
 * @author bianj
 * @author bianj
******************************************************************/

package com.jinznet.transit.controller.entity;

import java.util.Date;

/**
 * (BUYING_INFO)
 * 
 * @author bianj
 * @author bianj
 * @author bianj
 * @version 1.0.0 2018-08-18
 */
public class SaleMsg implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1475063907604574724L;
    
    /**  */
    private Integer id;
    
    /**  */
    private String openId;
    
    /**  */
    private String storeName;
    
    /**  */
    private String storeProvince;
    
    /**  */
    private String storeCity;
    
    /**  */
    private String saleName;
    
    /**  */
    private String salePhone;
    
    /** 推荐车主名字 */
    private String recommendCarName;
    
    /**  */
    private String recommendCarPhone;
    
    /**  */
    private String recommendCarVin;
    
    /**  */
    private Date creatTime;
    
    /**
     * 获取
     * 
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
     
    /**
     * 设置
     * 
     * @param id
     *          
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getOpenId() {
        return this.openId;
    }
     
    /**
     * 设置
     * 
     * @param openId
     *          
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getStoreName() {
        return this.storeName;
    }
     
    /**
     * 设置
     * 
     * @param storeName
     *          
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getStoreProvince() {
        return this.storeProvince;
    }
     
    /**
     * 设置
     * 
     * @param storeProvince
     *          
     */
    public void setStoreProvince(String storeProvince) {
        this.storeProvince = storeProvince;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getStoreCity() {
        return this.storeCity;
    }
     
    /**
     * 设置
     * 
     * @param storeCity
     *          
     */
    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getSaleName() {
        return this.saleName;
    }
     
    /**
     * 设置
     * 
     * @param saleName
     *          
     */
    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getSalePhone() {
        return this.salePhone;
    }
     
    /**
     * 设置
     * 
     * @param salePhone
     *          
     */
    public void setSalePhone(String salePhone) {
        this.salePhone = salePhone;
    }
    
    /**
     * 获取推荐车主名字
     * 
     * @return 推荐车主名字
     */
    public String getRecommendCarName() {
        return this.recommendCarName;
    }
     
    /**
     * 设置推荐车主名字
     * 
     * @param recommendCarName
     *          推荐车主名字
     */
    public void setRecommendCarName(String recommendCarName) {
        this.recommendCarName = recommendCarName;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getRecommendCarPhone() {
        return this.recommendCarPhone;
    }
     
    /**
     * 设置
     * 
     * @param recommendCarPhone
     *          
     */
    public void setRecommendCarPhone(String recommendCarPhone) {
        this.recommendCarPhone = recommendCarPhone;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getRecommendCarVin() {
        return this.recommendCarVin;
    }
     
    /**
     * 设置
     * 
     * @param recommendCarVin
     *          
     */
    public void setRecommendCarVin(String recommendCarVin) {
        this.recommendCarVin = recommendCarVin;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Date getCreatTime() {
        return this.creatTime;
    }
     
    /**
     * 设置
     * 
     * @param creatTime
     *          
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}