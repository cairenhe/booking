package com.crh.booking.common;

public class Config {

    /**登录和预订相关的信息**/
    public static String loginUserId = "jason1024";
    public static String loginPassword = "lucky,1024925";
    public static String payPassword = "111111";

    /**登录相关的地址**/
    public static String domainUrl = "www.yanlordlife.cn";
    public static String loginUrl = "/api/front/member/login";
    public static String venuesUrl = "/api/front/club/venues";
    public static String bookingDateUrl = "/api/front/club/venue/booking_date";
    public static String bookingCountUrl = "/api/front/club/venue/booking_court";
    public static String bookingScheduleUrl = "/api/front/club/venue/booking_schedule";
    public static String payUrl = "/api/front/club/venue/booking";
    public static String loginCookieKey = "connect.sid";
    public static String loginCookieValue = "s%3AugcF1HibfpMiaE504LrLZE_fHYMpanKQ.3IH06iUqaVMYgmaX1n1FnMXHV2lpTHcxPm8sg7uR23A";

    public static String getLoginUserId() {
        return loginUserId;
    }

    public static void setLoginUserId(String loginUserId) {
        Config.loginUserId = loginUserId;
    }

    public static String getLoginPassword() {
        return loginPassword;
    }

    public static void setLoginPassword(String loginPassword) {
        Config.loginPassword = loginPassword;
    }

    public static String getPayPassword() {
        return payPassword;
    }

    public static void setPayPassword(String payPassword) {
        Config.payPassword = payPassword;
    }

    public static String getDomainUrl() {
        return domainUrl;
    }

    public static void setDomainUrl(String domainUrl) {
        Config.domainUrl = domainUrl;
    }

    public static String getLoginUrl() {
        return loginUrl;
    }

    public static void setLoginUrl(String loginUrl) {
        Config.loginUrl = loginUrl;
    }

    public static String getVenuesUrl() {
        return venuesUrl;
    }

    public static void setVenuesUrl(String venuesUrl) {
        Config.venuesUrl = venuesUrl;
    }

    public static String getBookingDateUrl() {
        return bookingDateUrl;
    }

    public static void setBookingDateUrl(String bookingDateUrl) {
        Config.bookingDateUrl = bookingDateUrl;
    }

    public static String getBookingCountUrl() {
        return bookingCountUrl;
    }

    public static void setBookingCountUrl(String bookingCountUrl) {
        Config.bookingCountUrl = bookingCountUrl;
    }

    public static String getBookingScheduleUrl() {
        return bookingScheduleUrl;
    }

    public static void setBookingScheduleUrl(String bookingScheduleUrl) {
        Config.bookingScheduleUrl = bookingScheduleUrl;
    }

    public static String getPayUrl() {
        return payUrl;
    }

    public static void setPayUrl(String payUrl) {
        Config.payUrl = payUrl;
    }

    public static String getLoginCookieKey() {
        return loginCookieKey;
    }

    public static void setLoginCookieKey(String loginCookieKey) {
        Config.loginCookieKey = loginCookieKey;
    }

    public static String getLoginCookieValue() {
        return loginCookieValue;
    }

    public static void setLoginCookieValue(String loginCookieValue) {
        Config.loginCookieValue = loginCookieValue;
    }
}
