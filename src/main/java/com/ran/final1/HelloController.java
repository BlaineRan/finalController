package com.ran.final1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/get")
    @ResponseBody
    String getHello(){
        return "hello world";
    }
}
