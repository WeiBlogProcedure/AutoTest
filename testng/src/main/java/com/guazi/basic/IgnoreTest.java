package com.guazi.basic;

import org.testng.annotations.Test;

/**
 * @ClassName IgnoreTest
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/21 11:22 上午
 * @Version 1.0
 **/
public class IgnoreTest {
    /**
     * 忽略测试的应用场景：不想让该测试方法执行时，不可能将该方法删除掉再粘贴回来
     */
    @Test
    public void ignore1() {
        System.out.println("ignore1 执行！");
    }

    @Test(enabled = false)
    public void ignore2() {
        System.out.println("ignore2 执行！");
    }

    @Test(enabled = true)
    public void ignore3() {
        System.out.println("ignore3 执行！");
    }
}
