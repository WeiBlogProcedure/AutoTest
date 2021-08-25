package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.ibatis.session.SqlSession;
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
        TestConfig.defaultHttpClient = HttpClientBuilder.create().build();//使用该方法获取DefaultHttpClient请求
    }

    @Test(groups = "loginTrue", description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase", 1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }

    @Test(groups = "loginFalse", description = "用户登陆失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase", 2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }
}
