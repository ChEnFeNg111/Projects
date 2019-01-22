package com.westos.saasmarketing.marketingprogram.domain;

public class Industry {

    private int industryId;
    private String industryName;
    private int parentId;

    public Industry() {
    }

    public Industry(int industryId, String industryName, int parentId) {
        this.industryId = industryId;
        this.industryName = industryName;
        this.parentId = parentId;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "industryId=" + industryId +
                ", industryName='" + industryName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
