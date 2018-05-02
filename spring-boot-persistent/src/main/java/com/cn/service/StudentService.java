package com.cn.service;

import com.cn.entity.Student;

/**
 * @program: spring-boot-example
 * @description:
 * @author: 535504
 * @create: 2018-05-02 11:12
 **/
public interface StudentService {

    Student findByName(String name);

    Student findByNameAndAge(String name, Integer age);

    Student findUser(String name);

}
