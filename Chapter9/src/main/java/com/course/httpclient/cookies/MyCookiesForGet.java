package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @ClassName MyCookiesForGet
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/23 9:59 下午
 * @Version 1.0
 **/
public class MyCookiesForGet {
    private String host;
    private ResourceBundle bundle;//用来读取配置文件

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);//默认读取resources下的.properties文件
        host = bundle.getString("test.host");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中 拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String url = this.host+uri;

        HttpGet get= new HttpGet(url);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
