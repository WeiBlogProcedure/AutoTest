package com.guazi.groups;

import org.testng.annotations.Test;

/**
 * @ClassName GroupsOnClass3
 * @Description TODO 类分组
 * @Author lixinwei
 * @Date 2021/8/21 5:12 下午
 * @Version 1.0
 **/
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1() {
        System.out.println("GroupsOnClass3中的teacher1运行");
    }

    public void teacher2() {
        System.out.println("GroupsOnClass3中的teacher2运行");
    }
}
