package com.cn.service;

import com.cn.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(int id) {
        User user = jdbcTemplate.queryForObject("select * from user where id=?", new Object[]{id},new UserRowMapper());
        return user;
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from user",new UserRowMapper());
    }

    @Override
    public int deleteUserById(int id) {
        return jdbcTemplate.update("delete from user where id=?", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,id);
            }
        });
    }

    @Override
    public int updateUserById(User user) {
        return jdbcTemplate.update("update user SET name=?,age=?,address=? where id=?", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,user.getName());
                preparedStatement.setInt(2,user.getAge());
                preparedStatement.setString(3,user.getAddress());
                preparedStatement.setInt(4,user.getId());
            }
        });
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into user(name,age,address) VALUES (?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql,new String[]{"id"});
                preparedStatement.setString(1,user.getName());
                preparedStatement.setInt(2,user.getAge());
                preparedStatement.setString(3,user.getAddress());
                return preparedStatement;
            }
        },keyHolder);
        return Integer.parseInt(keyHolder.getKey().toString());
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
