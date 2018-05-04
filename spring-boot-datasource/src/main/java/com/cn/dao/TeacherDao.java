package com.cn.dao;

import com.cn.entity.t.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 11:02
 **/
public interface TeacherDao extends JpaRepository<Teacher,Integer> {

    Teacher findByName(String name);

}
