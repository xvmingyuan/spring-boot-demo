package com.cn.service;

import com.cn.entity.Student;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-11 10:51
 **/

public interface StudentService {

    Student getStudentByPrimaryKey(int id);

}
