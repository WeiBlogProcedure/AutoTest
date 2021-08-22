package com.guazi;

import org.testng.annotations.Test;

/**
 * @ClassName TimeOutTest
 * @Description TODO 超时测试
 * @Author lixinwei
 * @Date 2021/8/22 12:45 下午
 * @Version 1.0
 **/
public class TimeOutTest {
    /**
     * 应用场景：我计划等待5秒响应，然而没有响应那么就进行下一个方法
     * @throws InterruptedException
     */
    //单位为毫秒值
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }
}
