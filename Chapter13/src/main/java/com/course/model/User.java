package com.course.model;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/25 2:34 下午
 * @Version 1.0
 **/
@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
}
