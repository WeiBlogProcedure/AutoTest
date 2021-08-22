package com.guazi.multiThread;

import org.testng.annotations.Test;

/**
 * @ClassName MultiTreadOnXml
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/22 12:00 下午
 * @Version 1.0
 **/
public class MultiTreadOnXml {

    @Test
    public void test1() {
        System.out.printf("Thread Id : %s%n" , Thread.currentThread().getId());
    }

    @Test
    public void test2() {
        System.out.printf("Thread Id : %s%n" , Thread.currentThread().getId());
    }

    @Test
    public void test3() {
        System.out.printf("Thread Id : %s%n" , Thread.currentThread().getId());
    }
}
