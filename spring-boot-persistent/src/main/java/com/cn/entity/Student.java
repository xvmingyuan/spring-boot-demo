package com.cn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: spring-boot-example
 * @description: 学生实体类
 * @author: 535504
 * @create: 2018-05-02 10:47
 **/

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int age;

    private int grade;

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", grade=" + grade +
            '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
