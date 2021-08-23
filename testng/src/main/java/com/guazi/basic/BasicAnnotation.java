package com.guazi.basic;

import org.testng.annotations.*;

/**
 * @ClassName BasicAnnotation
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/22 12:15 下午
 * @Version 1.0
 **/
public class BasicAnnotation {

    @Test
    public void testCase1() {
        System.out.printf("Thread Id : %s%n" , Thread.currentThread().getId());
        System.out.println("Test这是测试用例11111");
    }

    @Test
    public void testCase2() {
        System.out.printf("Thread Id : %s%n" , Thread.currentThread().getId());
        System.out.println("Test这是测试用例2222");
    }

    /**
     * 在每个方法运行前运行
     */
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod这是在测试方法运行之前运行的");
    }

    /**
     * 在每个方法运行后运行
     */
    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod这是在测试方法运行之前运行的");
    }

    /**
     * 在第一个beforeMethod之前运行
     * 应用场景：在类正式运行之前是不是需要注册对象、变量赋值、静态等
     */
    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass这是在类运行之前运行的方法");
    }

    /**
     * 在最后一个afterMethod之后运行
     */
    @AfterClass
    public void afterClass() {
        System.out.println("afterClass这是在类运行之前运行的方法");
    }

    /**
     * 在beforeClass之前运行
     * 应用场景：可以包含多个class
     */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite测试套件");
    }

    /**
     * 在afterClass之后运行
     */
    @AfterSuite
    public void afterSuite() {
        System.out.println("beforeSuite测试套件");
    }
}
