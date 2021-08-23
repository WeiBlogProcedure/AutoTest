package com.guazi.suite;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @ClassName SuiteConfig
 * @Description TODO 套件测试
 * @Author lixinwei
 * @Date 2021/8/21 1:31 上午
 * @Version 1.0
 **/
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuit() {
        System.out.println("before suit运行了");
    }

    @AfterSuite
    public void afterSuit() {
        System.out.println("after suit运行了");
    }
}
