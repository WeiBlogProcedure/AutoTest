package com.guazi.suite;

import org.testng.annotations.Test;

/**
 * @ClassName ExpectedException
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/21 5:38 下午
 * @Version 1.0
 **/
public class ExpectedException {
    /**
     * 异常测试的应用场景：
     * 在我们期望结果为某一个异常的时候
     * 比如：我们传入了某些不合法的参数，程序抛出了异常
     * 也就是说我们的预期结果就是这个异常
     */
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess() {
        int index = 2;

        if (index == 1) {
            System.out.println("这是我的异常测试");
        }else {
            throw new RuntimeException();
        }
    }

    /**
     * 我们期望的是出现异常，出现异常的话，此case则运行成功
     */
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed() {
        System.out.println("这是一个失败的异常测试");
    }
}
