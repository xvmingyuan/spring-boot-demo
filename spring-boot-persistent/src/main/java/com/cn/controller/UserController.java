package com.cn.controller;

import com.cn.entity.User;
import com.cn.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUserById/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @RequestMapping("getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "updateUserById",method = RequestMethod.POST)
    public int updateUserByUd(User user) {
        return userService.updateUserById(user);
    }

    @RequestMapping(value = "insertUser",method = RequestMethod.POST)
    public int insertUser(User user) {
        return userService.insertUser(user);
    }

    @RequestMapping(value = "deleteUserById/{id}",method = RequestMethod.DELETE)
    public int deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
