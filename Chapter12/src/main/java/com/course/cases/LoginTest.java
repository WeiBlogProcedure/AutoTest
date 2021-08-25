package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @ClassName LoginTest
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 11:33 下午
 * @Version 1.0
 **/
public class LoginTest {
    @BeforeTest(groups = "loginTrue", description = "测试准备工作，获取HttpClient对象")
    public void beforeTest() {
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
//        TestConfig.defaultHttpClient = new DefaultHttpClient();//此方法已经被弃用
//        TestConfig.defaultHttpClient = HttpClientBuilder.create().build();//使用该方法获取DefaultHttpClient请求
        TestConfig.defaultHttpClient = HttpClients.createDefault();//或使用此方法来代替
    }

    @Test(groups = "loginTrue", description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase", 1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        //第一步：发送请求
        String result = getResult(loginCase);
        //第二步：验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
        System.out.println(result);
    }

    private String getResult(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());

        post.setHeader("content-type", "application/json");

        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //将client对象赋值，用来进行方法的执行，并设置Cookies信息
        //设置cookies信息后，在后边直接使用，不必重新赋值
        TestConfig.defaultHttpClient = HttpClients.custom().setDefaultCookieStore(TestConfig.store).build();

        String result;
        //执行post方法，得到响应结果
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        return result;
    }

    @Test(groups = "loginFalse", description = "用户登陆失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase", 2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
        //第一步：发送请求
        String result = getResult(loginCase);
        //第二步：验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
        System.out.println(result);
    }
}
