package com.hollysmart.personmodule.bean;

import java.io.Serializable;

public class PersonFuncItemBean implements Serializable {


    private String itemName;

    private int iconResource;//

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }
}
