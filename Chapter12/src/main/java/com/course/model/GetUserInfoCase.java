package com.course.model;

import lombok.Data;

/**
 * @ClassName GetUserInfoCase
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 11:08 下午
 * @Version 1.0
 **/
@Data
public class GetUserInfoCase {
    private int id;
    private int userId;
    private String expected;
}
