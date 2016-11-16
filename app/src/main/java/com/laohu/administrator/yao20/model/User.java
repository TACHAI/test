package com.laohu.administrator.yao20.model;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/9/26.
 */

public class User extends BmobUser {
    private String Info;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }
}
