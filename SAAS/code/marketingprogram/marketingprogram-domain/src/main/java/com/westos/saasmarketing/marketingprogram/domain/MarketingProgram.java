package com.westos.saasmarketing.marketingprogram.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * 营销方案表
 * @author chen
 */
public class MarketingProgram {

    /** 营销方案id*/
    private int programId;
    /** 营销方案名称*/
    private String name;
    /** 上传人*/
    private String author;
    /** 上传图片*/
    private String programImage;
    /** 价格*/
    private Double price;
    /** 附件*/
    private String programFile;
    /** 描述*/
    private String describtion;
    /** 上传时间*/
    private Timestamp publishTime;
    /** 上下架状态   yes：上架  no: 下架*/
    private String status;
    /** 下载量*/
    private int count;
    /** 是否付费    yes:需要付费 no:免费*/
    private String pay;
    /** 审核状态    yes: 已审核 no:未审核*/
    private String checkStatus;

    public MarketingProgram() {
    }

    public MarketingProgram(int programId, String name, String author, String programImage, Double price, String programFile, String describtion, Timestamp publishTime, String status, int count, String pay, String checkStatus) {
        this.programId = programId;
        this.name = name;
        this.author = author;
        this.programImage = programImage;
        this.price = price;
        this.programFile = programFile;
        this.describtion = describtion;
        this.publishTime = publishTime;
        this.status = status;
        this.count = count;
        this.pay = pay;
        this.checkStatus = checkStatus;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramid(int programId) {
        this.programId = programId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProgramImage() {
        return programImage;
    }

    public void setProgramImage(String programImage) {
        this.programImage = programImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProgramFile() {
        return programFile;
    }

    public void setProgramFile(String programFile) {
        this.programFile = programFile;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Override
    public String toString() {
        return "MarketingProgram{" +
                "programId=" + programId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", programImage='" + programImage + '\'' +
                ", price=" + price +
                ", programFile='" + programFile + '\'' +
                ", describtion='" + describtion + '\'' +
                ", publishTime=" + publishTime +
                ", status='" + status + '\'' +
                ", count=" + count +
                ", pay='" + pay + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                '}';
    }
}
