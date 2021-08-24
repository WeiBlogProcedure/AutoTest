package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SampleController
 * @Description TODO
 * @Author lixinwei
 * @Date 2021/8/24 1:14 下午
 * @Version 1.0
 **/
@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }

}
