package com.hollysmart.personmodule.common;

import android.view.View;

import com.hollysmart.personmodule.bean.PersonFuncItemBean;

import java.io.Serializable;
import java.util.List;

public class PersonConfig implements Serializable {

    private String userName;
    private String department;
    private String phoneNumber;
    private String headviewUrl;
    private List<PersonFuncItemBean> personFuncList;



    private int showFavor;
    private int showShare;
    private int showScan;
    private int showSetting;
    private int showFeed;
    private int showAbout;

    private String privacyTitle;
    private String serviceTitle;
    private String serviceUrl;
    private String privacyUrl;
    private String copyright;
    private String coptright_code;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHeadviewUrl() {
        return headviewUrl;
    }

    public void setHeadviewUrl(String headviewUrl) {
        this.headviewUrl = headviewUrl;
    }

    public int getShowFavor() {
        return showFavor;
    }

    public void setShowFavor(int showFavor) {
        this.showFavor = showFavor;
    }

    public int getShowShare() {
        return showShare;
    }

    public void setShowShare(int showShare) {
        this.showShare = showShare;
    }

    public int getShowScan() {
        return showScan;
    }

    public void setShowScan(int showScan) {
        this.showScan = showScan;
    }

    public int getShowSetting() {
        return showSetting;
    }

    public void setShowSetting(int showSetting) {
        this.showSetting = showSetting;
    }

    public int getShowFeed() {
        return showFeed;
    }

    public void setShowFeed(int showFeed) {
        this.showFeed = showFeed;
    }

    public int getShowAbout() {
        return showAbout;
    }

    public void setShowAbout(int showAbout) {
        this.showAbout = showAbout;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getPrivacyUrl() {
        return privacyUrl;
    }

    public void setPrivacyUrl(String privacyUrl) {
        this.privacyUrl = privacyUrl;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCoptright_code() {
        return coptright_code;
    }

    public void setCoptright_code(String coptright_code) {
        this.coptright_code = coptright_code;
    }

    public String getPrivacyTitle() {
        return privacyTitle;
    }

    public void setPrivacyTitle(String privacyTitle) {
        this.privacyTitle = privacyTitle;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<PersonFuncItemBean> getPersonFuncList() {
        return personFuncList;
    }

    public void setPersonFuncList(List<PersonFuncItemBean> personFuncList) {
        this.personFuncList = personFuncList;
    }
}
