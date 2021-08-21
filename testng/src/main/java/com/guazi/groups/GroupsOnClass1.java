package com.guazi.groups;

import org.testng.annotations.Test;

/**
 * @ClassName GroupsOnClass1
 * @Description TODO 类分组
 * @Author lixinwei
 * @Date 2021/8/21 5:11 下午
 * @Version 1.0
 **/
@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1() {
        System.out.println("GroupsOnClass1中的stu111111运行");
    }

    public void stu2() {
        System.out.println("GroupsOnClass1中的stu22222运行");
    }

}
