package com.cn.entity.s;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 11:02
 **/
public interface StudentDao extends JpaRepository<Student,Integer> {

    Student findByName(String name);

}
