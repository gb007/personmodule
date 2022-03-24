package com.hollysmart.personmodule.bean;

import java.io.Serializable;

public class PicBean implements Serializable {


    private String filename;

    private String filePath;

    private int isAddFlag = 1;//

    private String picId;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getIsAddFlag() {
        return isAddFlag;
    }

    public void setIsAddFlag(int isAddFlag) {
        this.isAddFlag = isAddFlag;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }
}
