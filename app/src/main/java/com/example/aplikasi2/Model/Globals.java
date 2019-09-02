package com.example.aplikasi2.Model;

import android.app.Application;

public class Globals extends Application {
    private Integer user_ID;
    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }

    private String user_Name;

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

}
