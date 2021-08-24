package com.course.server;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyGetMethod
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 1:24 下午
 * @Version 1.0
 **/
@RestController
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response) {
        //HttpServletRequest装请求信息的类
        //HttpServletResponse装响应信息的类
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得Cookies信息成功";
    }
}
