package com.example.aplikasi2.loginbstk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponLogin {

    @SerializedName("Status")
    @Expose
    private String Status;

    @SerializedName("Message")
    @Expose
    private String Message;

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

