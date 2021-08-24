package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyPostMethod
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 2:32 下午
 * @Version 1.0
 **/
@RestController
@Api(value = "/",description = "这是我全部的post请求")
public class MyPostMethod {
    private static Cookie cookie;//用来装我们的cookies信息

    //用户登录成功获取到cookies，然后再访问其他接口获取到列表

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response ,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password) {
        //(value = "userName", required = true
        //      前端的名字           等于true是必须传这个参数
        if (userName.equals("zhangsan") && password.equals("123456")) {
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功了！";
        }
        return "用户名或密码错误";
    }
}
