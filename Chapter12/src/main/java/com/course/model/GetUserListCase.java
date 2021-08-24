package com.course.model;

import lombok.Data;

/**
 * @ClassName GetUserListCase
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 11:09 下午
 * @Version 1.0
 **/
@Data
public class GetUserListCase {
    private int id;
    private String userName;
    private int age;
    private int sex;
    private String expected;
}
