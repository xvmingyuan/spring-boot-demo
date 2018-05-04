package com.cn.datasource;

import com.cn.dao.StudentDao;
import com.cn.dao.TeacherDao;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
@EntityScan("com.cn.entity.s")
@EnableJpaRepositories(basePackageClasses = StudentDao.class,
    entityManagerFactoryRef = "primaryEntityManagerFactory",
    transactionManagerRef = "primaryTransactionManager")
public class JpaPrimaryConfig {

        @Autowired
        @Qualifier("firstDataSource")
        public DataSource firstDataSource;

        @Bean
        @Primary
        PlatformTransactionManager primaryTransactionManager() {
            return new JpaTransactionManager(primaryEntityManagerFactory().getObject());
        }

        @Bean
        @Primary
        LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory() {
            HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
            jpaVendorAdapter.setGenerateDdl(true);
            jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
            jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
            LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
            factoryBean.setDataSource(firstDataSource);
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
