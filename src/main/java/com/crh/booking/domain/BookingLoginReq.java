package com.crh.booking.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class BookingLoginReq {
    @JsonProperty(value = "username")
    private String userName;
    private String password;

    public BookingLoginReq(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
