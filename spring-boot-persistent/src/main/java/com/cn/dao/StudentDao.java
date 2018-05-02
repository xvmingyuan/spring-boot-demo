package com.cn.dao;

import com.cn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 11:02
 **/
public interface StudentDao extends JpaRepository<Student,Integer> {

    Student findByName(String name);

    Student findByNameAndAge(String name, Integer age);

    @Query("from Student s where s.name=:name")
    Student findUser(@Param(value = "name") String name);

}
