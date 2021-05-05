package com.company.domain;

import java.util.Date;

public class ReplyVO {
    private int sbno;
    private int srbno;
    private int Target;
    private String writer;
    private String content;
    private Date regDate;
    private Date updateDate;
    private int replyNum;

    public ReplyVO(int sbno, int srbno, int target, String writer, String content, Date regDate, Date updateDate, int replyNum) {
        this.sbno = sbno;
        this.srbno = srbno;
        Target = target;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.replyNum = replyNum;
    }

    public ReplyVO() {
    }

    public int getSbno() {
        return sbno;
    }

    public int getSrbno() {
        return srbno;
    }

    public int getTarget() {
        return Target;
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

    public void setSbno(int sbno) {
        this.sbno = sbno;
    }

    public void setSrbno(int srbno) {
        this.srbno = srbno;
    }

    public void setTarget(int target) {
        Target = target;
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

    @Override
    public String toString() {
        return "ReplyVO{" +
                "sbno=" + sbno +
                ", srbno=" + srbno +
                ", Target=" + Target +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                ", updateDate=" + updateDate +
                ", replyNum=" + replyNum +
                '}';
    }
}
