package com.guazi.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @ClassName DataProviderTest
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/22 11:01 上午
 * @Version 1.0
 **/
public class DataProviderTest {

    /**
     * 数据来源
     * @param name
     * @param age
     */
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("name = " + name + " : age = " + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] o = new Object[][] {
                {"张三",10},
                {"李四",20},
                {"王五",30}
        };
        return o;
    }

    //支持根据方法来进行参数传递
    @Test(dataProvider = "methodData")
    public void test1(String name, int age) {
        System.out.println("test1111111方法 name = " + name + " age = " + age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {
        System.out.println("test222222方法 name = " + name + " age = " + age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test1")) {
            result = new Object[][] {
                    {"张三",20},
                    {"李四",25}
            };
        }else if (method.getName().equals("test2")) {
            result = new Object[][] {
                    {"王五",50},
                    {"赵六",60}
            };
        }
        return result;
    }
}
