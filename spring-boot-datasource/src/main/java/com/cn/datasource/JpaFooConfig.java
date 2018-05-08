package com.cn.datasource;

import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
    entityManagerFactoryRef = "entityManagerFactoryFoo",
    transactionManagerRef = "transactionManagerFoo",
    basePackages = {"com.cn.entity.s"})
public class JpaFooConfig {

    @Resource
    @Qualifier("fooDataSource")
    private DataSource fooDataSource;

    @Primary
    @Bean(name = "entityManagerFoo")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryFoo(builder).getObject().createEntityManager();
    }

    @Resource
    private JpaProperties jpaProperties;

    private Map<String, Object> getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

    /**
     * 设置实体类所在位置
     */
    @Primary
    @Bean(name = "entityManagerFactoryFoo")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFoo(EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(fooDataSource)
            .packages("com.cn.entity.s")
            .persistenceUnit("fooPersistenceUnit")
            .properties(getVendorProperties())
            .build();
    }

    @Primary
    @Bean(name = "transactionManagerFoo")
    public PlatformTransactionManager transactionManagerFoo(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryFoo(builder).getObject());
    }

}
