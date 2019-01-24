package com.westos.saasmarketing.marketingprogram.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
* 购买记录页面显示对象 ValueObject
 * */
public class CustomerProgramVO {

    /** 方案名称*/
    private String programName;
    /** 方案属性(多选)*/
    private List<String> list;
    /** 方案作者*/
    private String author;
    /** 方案购买时间*/
    private Timestamp buyingTime;
    /** 方案附件*/
    private String programFile;

    public CustomerProgramVO() {
    }

    public CustomerProgramVO(String programName, List<String> list, String author, Timestamp buyingTime, String programFile) {
        this.programName = programName;
        this.list = list;
        this.author = author;
        this.buyingTime = buyingTime;
        this.programFile = programFile;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(Timestamp buyingTime) {
        this.buyingTime = buyingTime;
    }

    public String getProgramFile() {
        return programFile;
    }

    public void setProgramFile(String programFile) {
        this.programFile = programFile;
    }

    @Override
    public String toString() {
        return "CustomerProgramVO{" +
                "programName='" + programName + '\'' +
                ", list=" + list +
                ", author='" + author + '\'' +
                ", buyingTime=" + buyingTime +
                ", programFile='" + programFile + '\'' +
                '}';
    }
}
