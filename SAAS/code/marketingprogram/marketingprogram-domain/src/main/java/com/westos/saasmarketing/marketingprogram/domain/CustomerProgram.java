package com.westos.saasmarketing.marketingprogram.domain;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *   购买记录表
 * @author chen
 *  */
public class CustomerProgram {

    /** 订单id*/
    private int orderId;
    /** 企业id*/
    private int qiYeId;
    /** 营销方案id*/
    private int programId;
    /** 购买时间*/
    private Timestamp buyingTime;
    /** 支付金额*/
    private double buyingMoney;

    public CustomerProgram() {
    }

    public CustomerProgram(int orderId, int qiYeId, int programId, Timestamp buyingTime, double buyingMoney) {
        this.orderId = orderId;
        this.qiYeId = qiYeId;
        this.programId = programId;
        this.buyingTime = buyingTime;
        this.buyingMoney = buyingMoney;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQiYeId() {
        return qiYeId;
    }

    public void setQiYeId(int qiYeId) {
        this.qiYeId = qiYeId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public Timestamp getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(Timestamp buyingTime) {
        this.buyingTime = buyingTime;
    }

    public double getBuyingMoney() {
        return buyingMoney;
    }

    public void setBuyingMoney(double buyingMoney) {
        this.buyingMoney = buyingMoney;
    }

    @Override
    public String toString() {
        return "CustomerProgram{" +
                "orderId=" + orderId +
                ", qiYeId=" + qiYeId +
                ", programId=" + programId +
                ", buyingTime=" + buyingTime +
                ", buyingMoney=" + buyingMoney +
                '}';
    }
}
