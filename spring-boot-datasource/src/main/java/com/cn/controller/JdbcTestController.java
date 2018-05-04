package com.cn.controller;

import com.cn.entity.u.User;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 09:58
 **/

@RestController
public class JdbcTestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUserById/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

}
