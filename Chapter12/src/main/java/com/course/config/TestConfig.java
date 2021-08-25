package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @ClassName TestConfig
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 11:17 下午
 * @Version 1.0
 **/
public class TestConfig {
    public static String loginUrl;
    public static String updateUserInfoUrl;
    public static String getUserListUrl;
    public static String getUserInfoUrl;
    public static String addUserUrl;

//    public static DefaultHttpClient defaultHttpClient;//此方法已作废
    public static HttpClient defaultHttpClient;
    public static CookieStore store;
}
