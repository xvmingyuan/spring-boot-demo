package com.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-example
 * @description: 控制层：helllocontroller
 * @author:
 * @create: 2018-04-28 10:49
 **/

@RestController
public class HelloController {

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: 535504
     * @Adress: http://localhost:8080/hello
     * @Date: 2018/4/28
     */
    @RequestMapping("hello")
    public String hello() {
        return "Hello World!";
    }

}
