package com.guazi.basic;

import org.testng.annotations.Test;

/**
 * @ClassName DependTest
 * @Description TODO 依赖测试
 * @Author lixinwei
 * @Date 2021/8/21 5:48 下午
 * @Version 1.0
 **/
public class DependTest {
    /**
     * 依赖测试
     * 一个方法的运行依赖于另一个方法,test1运行失败则test2不运行
     * 应用场景：该方法的返回值是下一个方法的入参
     * 比如：买东西之前需要先登录，登陆失败则买不了
     */
    @Test
    public void test1() {
        System.out.println("test1 run");
    }

    /**
     * 此处的test1就是上边的方法名
     */
    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        System.out.println("test2 run");
    }

    @Test
    public void test3() {
        System.out.println("test3333333 run");
        throw new RuntimeException();
    }

    /**
     * 此处的test3就是上边的方法名
     */
    @Test(dependsOnMethods = {"test3"})
    public void test4() {
        System.out.println("test4444444 run");
    }
}
