package com.cn.datasource;

import com.cn.dao.TeacherDao;
import com.cn.entity.s.Student;
import com.cn.entity.t.Teacher;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-04 10:54
 **/

@Configuration
@EnableTransactionManagement
@EntityScan("com.cn.entity.t")
@EnableJpaRepositories(basePackageClasses = TeacherDao.class,
    entityManagerFactoryRef = "secondEntityManagerFactory",
    transactionManagerRef = "secondTransactionManager")
public class JpaSecondConfig {
    @Autowired
    @Qualifier("secondDataSource")
    public DataSource secondDataSource;

    @Bean
    PlatformTransactionManager secondTransactionManager() {
        return new JpaTransactionManager(secondEntityManagerFactory().getObject());
    }

    @Bean
    LocalContainerEntityManagerFactoryBean secondEntityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(secondDataSource);

        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaPropertyMap(jpaProperties());

        return factoryBean;
    }

    private Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        //rops.put("hibernate.ejb.naming_strategy",new SpringNamingStrategy());
        return props;
    }

}
