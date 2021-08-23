package com.guazi.multiThread;

import org.testng.annotations.Test;

/**
 * @ClassName MultiThreadOnAnnotation
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/22 11:43 上午
 * @Version 1.0
 **/
public class MultiThreadOnAnnotation {
    private static int index = 1;
    /**
     * 用10个线程来执行,最好加个锁
     */
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test() {
        System.out.println(index++);
        //将当前运行线程的id打印出来
        System.out.printf("Thread Id : %s%n" , Thread.currentThread().getId());
    }
}
