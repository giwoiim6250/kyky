/******************************************************************
** 标    题：BuyingInfoEntity
** 创 建 者：bianj
** 创建日期：2018-08-18 10:42:00
** 描    述：
 * @author bianj
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
 * @author bianj
 * @version 1.0.0 2018-08-18
 */
public class SalePrize implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -3058504554925083434L;
    
    /**  */
    private Integer id;
    
    /**  */
    private String saleOpenId;
    
    /**  */
    private String saleName;
    
    /**  */
    private String storeName;
    
    /** 中奖描述 */
    private String prizeDes;
    
    /** 已推荐人数--冗余 */
    private Integer recommendCount;
    
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
    public String getSaleOpenId() {
        return this.saleOpenId;
    }
     
    /**
     * 设置
     * 
     * @param saleOpenId
     *          
     */
    public void setSaleOpenId(String saleOpenId) {
        this.saleOpenId = saleOpenId;
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
     * 获取中奖描述
     * 
     * @return 中奖描述
     */
    public String getPrizeDes() {
        return this.prizeDes;
    }
     
    /**
     * 设置中奖描述
     * 
     * @param prizeDes
     *          中奖描述
     */
    public void setPrizeDes(String prizeDes) {
        this.prizeDes = prizeDes;
    }
    
    /**
     * 获取已推荐人数--冗余
     * 
     * @return 已推荐人数--冗余
     */
    public Integer getRecommendCount() {
        return this.recommendCount;
    }
     
    /**
     * 设置已推荐人数--冗余
     * 
     * @param recommendCount
     *          已推荐人数--冗余
     */
    public void setRecommendCount(Integer recommendCount) {
        this.recommendCount = recommendCount;
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