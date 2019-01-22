package com.westos.saasmarketing.marketingprogram.dto;

import java.sql.Timestamp;
import java.util.List;

/**
 * 文件上传提交的表单数据
 * @author chen
 */
public class UploadMarketingDTO {

    /** 营销方案名称*/
    private String name;
    /** 上传人*/
    private String author;
    /** 上传图片*/
    private String programImage;
    /** 行业一级id*/
    private int parentId;
    /** 行业二级id*/
    private int industryId;
    /** 方案属性（多选）*/
    private List<String> list;
    /** 价格*/
    private Double price;
    /** 附件*/
    private String programFile;
    /** 描述*/
    private String describtion;
    /** 上传时间*/
    private Timestamp publishTime;



    public UploadMarketingDTO() {
    }

    public UploadMarketingDTO(String name, String author, String programImage, int parentId, int industryId, List<String> list, Double price, String programFile, String describtion) {
        this.name = name;
        this.author = author;
        this.programImage = programImage;
        this.parentId = parentId;
        this.industryId = industryId;
        this.list = list;
        this.price = price;
        this.programFile = programFile;
        this.describtion = describtion;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
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

    @Override
    public String toString() {
        return "UploadMarketingDTO{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", programImage='" + programImage + '\'' +
                ", parentId=" + parentId +
                ", industryId=" + industryId +
                ", list=" + list +
                ", price=" + price +
                ", programFile='" + programFile + '\'' +
                ", describtion='" + describtion + '\'' +
                '}';
    }
}
