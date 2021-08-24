package com.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 10:58 下午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String userName;
    private String password;
    private int age;
    private int sex;
    private int permission;
    private int isDelete;

    /**
     * json串
     * @return
     */
    @Override
    public String toString() {
        return ("id:" + id + "," +
                "userName:" + userName + "," +
                "password:" + password + "," +
                "age:" + age + "," +
                "sex:" + sex + "," +
                "permission:" + permission + "," +
                "isDelete:" + isDelete);
    }
}
