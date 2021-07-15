package com.crh.booking.domain;

import io.netty.handler.codec.http.cookie.Cookie;
import org.asynchttpclient.Response;

public class BookingContext {
    //关联登录用户的cookie
    private Cookie cookie;
    //运动类型ID：羽毛球场、乒乓球场等
    private String sportTypeId;
    //羽毛球场地类型ID：单人场、双人场
    private String venueTypeId;
    //预订日期
    private String bookingDate;
    //预订场次ID
    private String scheduleId;
    //登录用户名
    private String loginUserId;
    //登录密码
    private String loginPassword;
    //支付面
    private String payPassword;
    //http请求暂存
    private Response httpResponseTmp;

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public String getSportTypeId() {
        return sportTypeId;
    }

    public void setSportTypeId(String sportTypeId) {
        this.sportTypeId = sportTypeId;
    }

    public String getVenueTypeId() {
        return venueTypeId;
    }

    public void setVenueTypeId(String venueTypeId) {
        this.venueTypeId = venueTypeId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public Response getHttpResponseTmp() {
        return httpResponseTmp;
    }

    public void setHttpResponseTmp(Response httpResponseTmp) {
        this.httpResponseTmp = httpResponseTmp;
    }
}
