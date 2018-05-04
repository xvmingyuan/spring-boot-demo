package com.cn.service;

import com.cn.entity.u.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-02 10:07
 **/

@Service
public class UserServiceImpl implements UserService{

   /* @Autowired
    @Qualifier("aaa")*/
    protected JdbcTemplate jdbcTemplate1;

    /*@Autowired
    @Qualifier("bbb")*/
    protected JdbcTemplate jdbcTemplate2;

    @Override
    public User getUserById(int id) {
        User user = jdbcTemplate1.queryForObject("select * from user where id=?", new Object[]{id},new UserRowMapper());
        User user2 = jdbcTemplate2.queryForObject("select * from user where id=?", new Object[]{id},new UserRowMapper());
        System.out.println(user);
        System.out.println(user2);
        return user;
    }

}

class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        user.setAddress(resultSet.getString("address"));
        return user;
    }

}
