package com.cn.controller;

import com.cn.entity.Student;
import com.cn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 11:15
 **/
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("findByName/{name}")
    public Student findByName(@PathVariable String name) {
        return studentService.findByName(name);
    }

    @RequestMapping("findByNameAndAge")
    public Student findByNameAndAge(@RequestParam("name") String name,@RequestParam("age") Integer age) {
        return studentService.findByNameAndAge(name,age);
    }

    @RequestMapping("findUser/{name}")
    public Student findUser(@PathVariable String name) {
        return studentService.findUser(name);
    }
}
