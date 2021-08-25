package com.course.model;

import lombok.Data;

/**
 * @ClassName AddUserCase
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 11:05 下午
 * @Version 1.0
 **/
@Data
public class AddUserCase {
    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
    private String expected;
}
