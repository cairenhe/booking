package com.crh.booking.service;

import com.crh.booking.common.Config;
import com.crh.booking.domain.BookingContext;
import com.crh.booking.domain.BookingLoginReq;
import com.crh.booking.domain.BookingLoginResp;
import com.crh.booking.util.JsonUtil;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.handler.codec.http.cookie.DefaultCookie;
import io.netty.util.internal.StringUtil;
import org.asynchttpclient.*;
import org.asynchttpclient.util.HttpConstants;
import org.asynchttpclient.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    public static void main(String args[]){
        BookingService.booking();
    }

    /**
     * 预订
     */
    public static boolean booking(){
        try{
            //初始化上下文
            BookingContext bookingContext = initBookingContext();

            //登录
            login(bookingContext);
        }catch (Exception e){
            logger.error("Failed to booking.");
            return false;
        }
        return true;
    }

    /**
     * 初始化上下文
     * @return 上下文
     */
    private static BookingContext initBookingContext(){
        BookingContext bookingContext = new BookingContext();
        bookingContext.setLoginUserId(Config.getLoginUserId());
        bookingContext.setLoginPassword(Config.getLoginPassword());
        bookingContext.setPayPassword(Config.getPayPassword());
        DefaultCookie cookie = new DefaultCookie(Config.getLoginCookieKey(),Config.getLoginCookieValue());
        bookingContext.setCookie(cookie);
        return bookingContext;
    }


    private static void login(BookingContext bookingContext) throws Exception {
        DefaultAsyncHttpClient httpClient = new DefaultAsyncHttpClient();
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.addCookie(bookingContext.getCookie());
        requestBuilder.setUrl("http://" + Config.getDomainUrl() + Config.getLoginUrl());
        requestBuilder.setBody(JsonUtil.toJson(new BookingLoginReq(Config.getLoginUserId(), Config.getLoginPassword())));
        requestBuilder.setMethod("POST");
        defaultHttpHeadSetting(requestBuilder);
        ListenableFuture<Response> listenableFuture = httpClient.executeRequest(requestBuilder);
        try {
            Response response = listenableFuture.toCompletableFuture().get(1000, TimeUnit.MILLISECONDS);
            bookingContext.setHttpResponseTmp(response);
            String bodyStr = response.getResponseBody(Charset.forName("utf-8"));
            if(200 != response.getStatusCode()){
                logger.error("Failed to login, status is not 200.");
                throw new Exception("Failed to login, status is not 200.");
            }
            if(StringUtil.isNullOrEmpty(bodyStr)){
                logger.error("Failed to login, the respBody is empty.");
                throw new Exception("Failed to login, the respBody is empty.");
            }
            BookingLoginResp bookingLoginResp;
            try{
                bookingLoginResp = JsonUtil.fromJson(bodyStr, BookingLoginResp.class);
            }catch (Exception e){
                logger.error("Failed to login, the respBody is not json.");
                throw new Exception("Failed to login, the respBody is not json.");
            }
            if(bookingLoginResp == null){
                logger.error("Failed to login, the respBody is null after json parse.");
                throw new Exception("Failed to login, the respBody is null after json parse.");
            }
            logger.info("login result:" + bookingLoginResp);
            if(0 != bookingLoginResp.getCode()){
                logger.error("Failed to login, message is " + bookingLoginResp.getMessage());
                throw new Exception("Failed to login, message is " + bookingLoginResp.getMessage());
            }
            logger.info("success to login.");

        } catch (InterruptedException e) {
            logger.error("login been interrupted.");
            throw new Exception("login been interrupted.");
        } catch (ExecutionException e) {
            logger.error("login has ExecutionException.");
            throw new Exception("ogin has ExecutionException.");
        } catch (TimeoutException e) {
            logger.error("login timeout .");
            throw new Exception("login timeout .");
        }
    }

    private static void defaultHttpHeadSetting(RequestBuilder requestBuilder){
        if(requestBuilder == null){
            logger.error("the requestBuilder is null.");
            return;
        }
        requestBuilder.setHeader("Accept"," application/json, text/plain, */*");
        requestBuilder.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        requestBuilder.setHeader("Content-Type","application/json;charset=UTF-8");
        requestBuilder.setHeader("Origin","http://www.yanlordlife.cn");
        requestBuilder.setHeader("Accept-Encoding","gzip, deflate");
        requestBuilder.setHeader("Accept-Language"," zh-CN,zh;q=0.9");
    }
}


