package com.cn.service;


import com.cn.entity.User;
import java.util.List;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 10:02
 **/

public interface UserService {

    User getUserById(int id);

    List<User> getUsers();

    int deleteUserById(int id);

    int updateUserById(User user);

    int insertUser(User user);

}
