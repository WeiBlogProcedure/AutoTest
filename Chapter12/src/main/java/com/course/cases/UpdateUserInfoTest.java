package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @ClassName UpdateUserInfoTest
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/25 1:09 下午
 * @Version 1.0
 **/
public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "loginTrue", description = "更改用户信息")
    public void updateUserInfo() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase", 1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);

        int result = getResult(updateUserInfoCase);

        User user = session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);

        //判断查出来的用户是否为空
        Assert.assertNotNull(result);
        Assert.assertNotNull(user);
    }

    private int getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException, InterruptedException {
        HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);
        JSONObject param = new JSONObject();
        //设置参数
        param.put("id",updateUserInfoCase.getUserId());
        param.put("userName",updateUserInfoCase.getUserName());
        param.put("age",updateUserInfoCase.getAge());
        param.put("sex",updateUserInfoCase.getSex());
        param.put("permission",updateUserInfoCase.getPermission());
        param.put("isDelete",updateUserInfoCase.getIsDelete());
        //设置头信息
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);

        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        result = EntityUtils.toString(response.getEntity(),"utf-8");

        Thread.sleep(10000);

        return Integer.parseInt(result);
    }

    @Test(dependsOnGroups = "loginTrue", description = "删除用户信息")
    public void deleteUser() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase", 2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);

        int result = getResult(updateUserInfoCase);

        User user = session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);

        //判断查出来的用户是否为空
        Assert.assertNotNull(result);
        Assert.assertNotNull(user);
    }
}
