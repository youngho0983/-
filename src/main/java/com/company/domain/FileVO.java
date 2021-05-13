package com.company.domain;

public class FileVO {
    private String fileName;
    private String id;
    private int pbno;

    @Override
    public String toString() {
        return "FileVO{" +
                "fileName='" + fileName + '\'' +
                ", id='" + id + '\'' +
                ", pbno=" + pbno +
                '}';
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

    public int getPbno() {
        return pbno;
    }

    public void setPbno(int pbno) {
        this.pbno = pbno;
    }

    public FileVO(String fileName, String id, int pbno) {
        this.fileName = fileName;
        this.id = id;
        this.pbno = pbno;
    }

    public FileVO() {
    }
}
