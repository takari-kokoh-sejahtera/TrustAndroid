package com.example.aplikasi2.Model;

import android.app.Application;
import android.view.View;
import android.widget.LinearLayout;

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

    //untuk enable disable control
    public static void enableControl(boolean enabled, LinearLayout layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof LinearLayout) {
                LinearLayout layouts = (LinearLayout) child;
                enableControl(false, layouts);
            }
            child.setEnabled(false);
        }
    }
}
