package com.cn;

import com.cn.entity.s.StudentDao;
import com.cn.entity.t.TeacherDao;
import com.cn.entity.s.Student;
import com.cn.entity.t.Teacher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Qualifier("fooJdbcTemplate")
	@Autowired
	protected JdbcTemplate fooJdbcTemplate;

	@Qualifier("barJdbcTemplate")
	@Autowired
	protected JdbcTemplate barJdbcTemplate;

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TeacherDao teacherDao;

	@Before
	public void setUp() {
		studentDao.save(new Student("aaa",3,4));
		teacherDao.save(new Teacher("bbb","4","11"));
	}

	@Test
	public void test() throws Exception {

		fooJdbcTemplate.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
		fooJdbcTemplate.update("insert into user(id,name,age) values(?, ?, ?)", 2, "bbb", 30);

		barJdbcTemplate.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);

		//校验
		Assert.assertEquals("2", fooJdbcTemplate.queryForObject("select count(1) from user", String.class));
		Assert.assertEquals("1", barJdbcTemplate.queryForObject("select count(1) from user", String.class));

	}

	@Test
	public void test1() throws Exception {
		System.out.println(studentDao.findByName("aaa"));
		System.out.println(teacherDao.findByName("bbb"));
	}

}
