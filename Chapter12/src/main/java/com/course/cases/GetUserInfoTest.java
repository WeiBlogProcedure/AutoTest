package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

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
    }
}
