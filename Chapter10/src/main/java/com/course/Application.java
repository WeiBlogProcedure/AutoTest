package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName com.course.Application
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 1:21 下午
 * @Version 1.0
 **/
@SpringBootApplication
@ComponentScan("com.course.server")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
