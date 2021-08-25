package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName GetUserInfoTest
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/25 1:06 下午
 * @Version 1.0
 **/
public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue", description = "获取UserId为1的用户")
    public void getUserInfo() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = session.selectOne("getUserInfoCase", 1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);

        JSONArray resultJson = getJsonResult(getUserInfoCase);

        User user = session.selectOne(getUserInfoCase.getExpected(), getUserInfoCase);
        List userList = new ArrayList();

        userList.add(user);

        JSONArray jsonArray = new JSONArray(userList);
        JSONArray jsonArray1 = new JSONArray(resultJson.getString(0));

        Assert.assertEquals(jsonArray.toString(),jsonArray1.toString());
    }

    private JSONArray getJsonResult(GetUserInfoCase getUserInfoCase) throws IOException {
        //使用post请求访问url
        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("id",getUserInfoCase.getUserId());
        //设置头信息
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);

        String result;
        //获取响应结果
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        result = EntityUtils.toString(response.getEntity(),"utf-8");

        //转化为list
        List resultList = Arrays.asList(result);

        JSONArray jsonArray = new JSONArray(resultList);
        return jsonArray;
    }
}
