package com.cn.controller;

import com.cn.entity.s.Student;
import com.cn.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 11:15
 */

@RestController
public class JpaTestController {

    @Autowired
    private JpaService jpaService;

    @RequestMapping("findByName/{name}")
    public Student findByName(@PathVariable String name) {
        return jpaService.findByName(name);
    }

}
