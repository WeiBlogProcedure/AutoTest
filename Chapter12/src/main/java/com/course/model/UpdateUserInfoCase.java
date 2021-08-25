package com.course.model;

import lombok.Data;

/**
 * @ClassName UpdateUserInfoCase
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 11:12 下午
 * @Version 1.0
 **/
@Data
public class UpdateUserInfoCase {
    private int id;
    private int userId;
    private String userName;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
    private String expected;
}
