package com.example.aplikasi2.loginbstk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponLogin {

    private String Status;

    private String Message;

    private Integer Value;

    public Integer getValue() {
        return Value;
    }

    public void setValue(Integer value) {
        Value = value;
    }


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
//    @SerializedName("Message")
//    @Expose
//    private User data;

}

