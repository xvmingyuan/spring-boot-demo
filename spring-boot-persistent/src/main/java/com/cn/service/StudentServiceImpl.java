package com.cn.service;

import com.cn.dao.StudentDao;
import com.cn.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 11:13
 **/
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    public Student findByNameAndAge(String name, Integer age) {
        return studentDao.findByNameAndAge(name,age);
    }

    @Override
    public Student findUser(String name) {
        return studentDao.findUser(name);
    }
}
