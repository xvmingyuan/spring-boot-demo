package com.cn.controller;

import com.cn.entity.Student;
import com.cn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-11 10:50
 **/
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getStudentByKey/{id}")
    public Student getStudentByKey(@PathVariable int id) {
        return studentService.getStudentByPrimaryKey(id);
    }

}
