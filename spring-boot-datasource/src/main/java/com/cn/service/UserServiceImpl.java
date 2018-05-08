package com.cn.service;

import com.cn.entity.u.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 10:07
 **/

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("fooJdbcTemplate")
    protected JdbcTemplate fooJdbcTemplate;

    @Autowired
    @Qualifier("barJdbcTemplate")
    protected JdbcTemplate barJdbcTemplate;

    @Override
    public User getUserById(int id) {
        User user = fooJdbcTemplate.queryForObject("select * from user where id=?", new Object[]{id},new UserRowMapper());
        User user2 = barJdbcTemplate.queryForObject("select * from user where id=?", new Object[]{id},new UserRowMapper());
        System.out.println(user);
        System.out.println(user2);
        return user;
    }

}
