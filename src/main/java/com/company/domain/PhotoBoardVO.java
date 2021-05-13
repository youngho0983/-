package com.company.domain;

import java.util.Date;

public class PhotoBoardVO {
    private int pbno;
    private int replyNum;
    private int seenNum;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updateDate;
    private String fileName;
    private String id;

    @Override
    public String toString() {
        return "PhotoBoardVO{" +
                "pbno=" + pbno +
                ", replyNum=" + replyNum +
                ", seenNum=" + seenNum +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                ", updateDate=" + updateDate +
                ", fileName='" + fileName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public PhotoBoardVO() {
    }

    public PhotoBoardVO(int pbno, int replyNum, int seenNum, String title, String writer, String content, Date regDate, Date updateDate, String fileName, String id) {
        this.pbno = pbno;
        this.replyNum = replyNum;
        this.seenNum = seenNum;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.fileName = fileName;
        this.id = id;
    }

    public int getPbno() {
        return pbno;
    }

    public void setPbno(int pbno) {
        this.pbno = pbno;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public int getSeenNum() {
        return seenNum;
    }

    public void setSeenNum(int seenNum) {
        this.seenNum = seenNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
