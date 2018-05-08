package com.cn.datasource;

import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
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
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactoryBar",
    transactionManagerRef = "transactionManagerBar",
    basePackages = {"com.cn.entity.t"})//repository的目录
public class JpaBarConfig {

    @Autowired
    @Qualifier("barDataSource")
    private DataSource barDataSource;

    @Bean(name = "entityManagerBar")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBar(builder).getObject().createEntityManager();
    }

    @Resource
    private JpaProperties jpaProperties;

    private Map<String, Object> getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

    @Bean(name = "entityManagerFactoryBar")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBar(EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(barDataSource)
            .packages("com.cn.entity.t")//实体类的目录
            .persistenceUnit("barPersistenceUnit")
            .properties(getVendorProperties())
            .build();
    }

    @Bean(name = "transactionManagerBar")
    PlatformTransactionManager transactionManagerBar(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBar(builder).getObject());
    }

}
