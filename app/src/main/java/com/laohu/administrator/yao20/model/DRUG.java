package com.laohu.administrator.yao20.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/9/29.
 */

public class DRUG extends BmobObject {
    private String SUBCLASS;
    private String NAME;
    private String FLAVOR_MERIDIAN;
    private String EFFECT;
    private String CLASSES;

    public String getSUBCLASS() {
        return SUBCLASS;
    }

    public void setSUBCLASS(String SUBCLASS) {
        this.SUBCLASS = SUBCLASS;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getFLAVOR_MERIDIAN() {
        return FLAVOR_MERIDIAN;
    }

    public void setFLAVOR_MERIDIAN(String FLAVOR_MERIDIAN) {
        this.FLAVOR_MERIDIAN = FLAVOR_MERIDIAN;
    }

    public String getEFFECT() {
        return EFFECT;
    }

    public void setEFFECT(String EFFECT) {
        this.EFFECT = EFFECT;
    }

    public String getCLASSES() {
        return CLASSES;
    }

    public void setCLASSES(String CLASSES) {
        this.CLASSES = CLASSES;
    }
}
