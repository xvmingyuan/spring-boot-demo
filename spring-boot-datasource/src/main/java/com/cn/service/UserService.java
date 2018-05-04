package com.cn.service;


import com.cn.entity.u.User;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 10:02
 **/

public interface UserService {

    User getUserById(int id);

}
