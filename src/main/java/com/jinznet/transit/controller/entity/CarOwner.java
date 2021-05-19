/******************************************************************
** 标    题：BuyingInfoEntity
** 创 建 者：bianj
** 创建日期：2018-08-18 10:42:00
** 描    述：
 * @author bianj
******************************************************************/

package com.jinznet.transit.controller.entity;
import java.util.Date;

/**
 * (BUYING_INFO)
 * 
 * @author bianj
 * @author bianj
 * @version 1.0.0 2018-08-18
 */
public class CarOwner implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -7906131580771393764L;
    
    /**  */
    private Integer id;
    
    /**  */
    private String openId;
    
    /**  */
    private String name;
    
    /**  */
    private String phone;
    
    /** 车辆代码 */
    private String vin;
    
    /**  */
    private Date buyCarTime;
    
    /**  */
    private Date createTime;
    
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
    public String getName() {
        return this.name;
    }
     
    /**
     * 设置
     * 
     * @param name
     *          
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public String getPhone() {
        return this.phone;
    }
     
    /**
     * 设置
     * 
     * @param phone
     *          
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * 获取车辆代码
     * 
     * @return 车辆代码
     */
    public String getVin() {
        return this.vin;
    }
     
    /**
     * 设置车辆代码
     * 
     * @param vin
     *          车辆代码
     */
    public void setVin(String vin) {
        this.vin = vin;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Date getBuyCarTime() {
        return this.buyCarTime;
    }
     
    /**
     * 设置
     * 
     * @param buyCarTime
     *          
     */
    public void setBuyCarTime(Date buyCarTime) {
        this.buyCarTime = buyCarTime;
    }
    
    /**
     * 获取
     * 
     * @return 
     */
    public Date getCreateTime() {
        return this.createTime;
    }
     
    /**
     * 设置
     * 
     * @param createTime
     *          
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}