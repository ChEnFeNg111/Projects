package com.westos.saasmarketing.marketingprogram.vo;

import java.sql.Timestamp;
import java.util.List;

/**
* 上传记录页面显示对象 ValueObject
 * */
public class CustomerHistoryProgramVO {

    /** 方案名称*/
    private String programName;
    /** 方案属性(多选)*/
    private List<String> list;
    /** 方案价格*/
    private  Double price;
    /** 方案审核状态*/
    private String checkStatus;
    /** 方案上传时间*/
    private Timestamp publishTime;
    /** 方案下载次数*/
    private int count;


    public CustomerHistoryProgramVO() {
    }


    public CustomerHistoryProgramVO(String programName, List<String> list, Double price, String checkStatus, Timestamp publishTime, int count) {
        this.programName = programName;
        this.list = list;
        this.price = price;
        this.checkStatus = checkStatus;
        this.publishTime = publishTime;
        this.count = count;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CustomerHistoryProgramVO{" +
                "programName='" + programName + '\'' +
                ", list=" + list +
                ", price=" + price +
                ", checkStatus='" + checkStatus + '\'' +
                ", publishTime=" + publishTime +
                ", count=" + count +
                '}';
    }
}
