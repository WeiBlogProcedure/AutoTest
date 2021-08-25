package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
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
    public void addUser() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = session.selectOne("addUserCase", 1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);
    }
}
