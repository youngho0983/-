package com.company.domain;

import lombok.*;

import java.util.Date;


public class SimpleBoardVO {
    private int sbno;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updateDate;
    private int replyNum;
    private int seenNum;

    public SimpleBoardVO(int sbno, String title, String wrtier, String content, Date regDate, Date updateDate, int replyNum, int seenNum) {
        this.sbno = sbno;
        this.title = title;
        this.writer = wrtier;
        this.content = content;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.replyNum = replyNum;
        this.seenNum = seenNum;
    }

    public SimpleBoardVO() {
    }

    public int getSbno() {
        return sbno;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public int getSeenNum() {
        return seenNum;
    }

    public void setSbno(int sbno) {
        this.sbno = sbno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public void setSeenNum(int seenNum) {
        this.seenNum = seenNum;
    }

    @Override
    public String toString() {
        return "SimpleBoardVO{" +
                "sbno=" + sbno +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                ", updateDate=" + updateDate +
                ", replyNum=" + replyNum +
                ", seenNum=" + seenNum +
                '}';
    }

}
