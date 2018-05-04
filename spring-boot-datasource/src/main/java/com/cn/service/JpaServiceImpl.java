package com.cn.service;

import com.cn.dao.StudentDao;
import com.cn.entity.s.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 11:13
 **/
@Service
public class JpaServiceImpl implements JpaService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findByName(String name) {
        return studentDao.findByName(name);
    }

}
