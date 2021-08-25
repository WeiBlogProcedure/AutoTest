package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @ClassName AddUserCase
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/25 12:59 下午
 * @Version 1.0
 **/
public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue", description = "添加用户接口测试")
    public void addUser() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("addUserCase", 1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);

        //发请求，获取结果
        String result = getResult(addUserCase);
        //getResult调取接口需要时间，不是同一进程
        Thread.sleep(5000);//等待3秒再执行后边语句
        //验证返回结果
        User user = session.selectOne("addUser",addUserCase);
//        System.out.println(user.toString());
        Assert.assertEquals(addUserCase.getExpected(),result);
    }

    private String getResult(AddUserCase addUserCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("age",addUserCase.getAge());
        param.put("sex",addUserCase.getSex());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());

        //设置头信息
        post.setHeader("content-type","application/json");

        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //这两行代码不必在这一流程中进行，因为登录时已经给TestConfig.defaultHttpClient设置了cookue
        //用的时候不必在进行赋值，否则cookie就会更新
//        TestConfig.store = new BasicCookieStore();
//        TestConfig.defaultHttpClient = HttpClients.custom().setDefaultCookieStore(TestConfig.store).build();
        String result;//存放返回结果
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        return result;
    }
}
