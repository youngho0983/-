package com.company.domain;

public class PageAndCriteriaVO {
    private int pageNum;
    private int criteria;

    public PageAndCriteriaVO() {
    }

    public PageAndCriteriaVO(int pageNum, int criteria) {
        this.pageNum = pageNum;
        this.criteria = criteria;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setCriteria(int criteria) {
        this.criteria = criteria;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getCriteria() {
        return criteria;
    }
}
