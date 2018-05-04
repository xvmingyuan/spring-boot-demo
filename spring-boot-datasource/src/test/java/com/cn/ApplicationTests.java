package com.cn;

import com.cn.dao.StudentDao;
import com.cn.dao.TeacherDao;
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

	@Qualifier("firstJdbcTemplate")
	@Autowired
	protected JdbcTemplate jdbcTemplate1;

	@Qualifier("secondJdbcTemplate")
	@Autowired
	protected JdbcTemplate jdbcTemplate2;

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TeacherDao teacherDao;


	@Before
	public void setUp() {
		jdbcTemplate1.update("DELETE  FROM  user ");
		jdbcTemplate2.update("DELETE  FROM  user ");

		studentDao.save(new Student(){
			{
				this.setAge(3);
				this.setGrade(1);
				this.setName("张三");
			}
		});
		teacherDao.save(new Teacher(){
			{
				this.setAge("4");
				this.setCourse("数据");
				this.setName("李四");
			}
		});
	}

	@Test
	public void test() throws Exception {

		// 往第一个数据源中插入两条数据
		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 2, "bbb", 30);

		// 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
		jdbcTemplate2.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);

		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));

		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));

	}



	@Test
	public void test1() throws Exception {
		System.out.println(studentDao.findByName("张三"));
		System.out.println(teacherDao.findByName("李四"));
	}



}
