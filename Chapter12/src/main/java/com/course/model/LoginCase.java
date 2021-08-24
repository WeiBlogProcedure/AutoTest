package com.course.model;

import lombok.Data;

/**
 * @ClassName LoginCase
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 11:11 下午
 * @Version 1.0
 **/
@Data
public class LoginCase {;
    private int id;
    private String userName;
    private String password;
    private String expected;
}
