package com.guazi.basic;

import org.testng.annotations.Test;

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
}
