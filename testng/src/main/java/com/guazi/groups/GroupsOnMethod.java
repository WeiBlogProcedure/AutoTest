package com.guazi.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @ClassName GroupsOnMethod
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/21 11:37 上午
 * @Version 1.0
 **/
public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1() {
        System.out.println("这是服务端组的测试方法1111111");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("这是服务端组的测试方法2222222");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("这是客户端组的测试方法3333333");
    }

    @Test(groups = "client")
    public void test4() {
        System.out.println("这是客户端组的测试方法4444444");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer() {
        System.out.println("这是服务端组运行前运行的方法");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer() {
        System.out.println("这是服务端组运行后运行的方法");
        System.out.println("=======================");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient() {
        System.out.println("这是客户端组运行前运行的方法");
    }

    @AfterGroups(value = "client",enabled = false)
    public void afterGroupsOnClient() {
        System.out.println("这是客户端组运行后运行的方法");
    }
}
