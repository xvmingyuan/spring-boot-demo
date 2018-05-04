package com.cn.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: spring-boot-example
 * @description: 数据源配置类
 * @author:
 * @create: 2018-05-03 14:35
 **/

@Configuration
public class JdbcDataSourceConfig {

    /*@Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="app.datasource.primary")
    public DataSource primaryDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSourceBuilder type = dataSourceBuilder.type(HikariDataSource.class);
        DataSource build = type.build();
        return build;
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="app.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "aaa")
    public JdbcTemplate primaryJdbcTemplate(
        @Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "bbb")
    public JdbcTemplate secondaryJdbcTemplate(
        @Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }*/

    /*@Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "aaa")
    public JdbcTemplate primaryJdbcTemplate(
        @Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "bbb")
    public JdbcTemplate secondaryJdbcTemplate(
        @Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }*/

    @Primary
    @Bean(name = "dataSourcePropertiesPrimary")
    @Qualifier("dataSourcePropertiesPrimary")
    @ConfigurationProperties(prefix="app.datasource.primary")
    public DataSourceProperties dataSourcePropertiesPrimary() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "firstDataSource")
    @Qualifier("firstDataSource")
    @ConfigurationProperties(prefix="app.datasource.primary")
    public DataSource firstDataSource(@Qualifier("dataSourcePropertiesPrimary") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "dataSourcePropertiesSecond")
    @Qualifier("dataSourcePropertiesSecond")
    @ConfigurationProperties(prefix="app.datasource.secondary")
    public DataSourceProperties dataSourcePropertiesSecond() {
        return new DataSourceProperties();
    }

    @Bean(name = "secondDataSource")
    @Qualifier("secondDataSource")
    @ConfigurationProperties(prefix="app.datasource.secondary")
    public DataSource secondDataSource(@Qualifier("dataSourcePropertiesSecond") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "firstJdbcTemplate")
    @Qualifier("firstJdbcTemplate")
    public JdbcTemplate firstJdbcTemplate(@Qualifier("firstDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondJdbcTemplate")
    @Qualifier("secondJdbcTemplate")
    public JdbcTemplate secondJdbcTemplate(@Qualifier("secondDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
