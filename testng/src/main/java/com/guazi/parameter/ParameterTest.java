package com.guazi.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @ClassName ParameterTest
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/21 6:40 下午
 * @Version 1.0
 **/
public class ParameterTest {

    @Test
    @Parameters({"name","age"})
    public void parameterTest1(String name, int age) {
        System.out.println("name = " + name + " : age = " + age);
    }
}
