package com.cn.service;

import com.cn.common.redis.RedisCache;
import com.cn.entity.Student;
import com.cn.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-11 10:55
 **/
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @RedisCache(type = Student.class)
    public Student getStudentByPrimaryKey(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
