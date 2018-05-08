package com.cn.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @program: spring-boot-example
 * @description: 数据源配置类
 * @author:
 * @create: 2018-05-03 14:35
 **/

@Configuration
public class JdbcDataSourceConfig {

    @Primary
    @Bean(name = "dataSourcePropertiesFoo")
    @Qualifier("dataSourcePropertiesFoo")
    @ConfigurationProperties(prefix="app.datasource.foo")
    public DataSourceProperties dataSourcePropertiesFoo() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "FooDataSource")
    @Qualifier("FooDataSource")
    @ConfigurationProperties(prefix="app.datasource.foo")
    public DataSource FooDataSource(@Qualifier("dataSourcePropertiesFoo") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "dataSourcePropertiesBar")
    @Qualifier("dataSourcePropertiesBar")
    @ConfigurationProperties(prefix="app.datasource.bar")
    public DataSourceProperties dataSourcePropertiesBar() {
        return new DataSourceProperties();
    }

    @Bean(name = "barDataSource")
    @Qualifier("barDataSource")
    @ConfigurationProperties(prefix="app.datasource.bar")
    public DataSource barDataSource(@Qualifier("dataSourcePropertiesBar") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "fooJdbcTemplate")
    @Qualifier("fooJdbcTemplate")
    public JdbcTemplate fooJdbcTemplate(@Qualifier("FooDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "barJdbcTemplate")
    @Qualifier("barJdbcTemplate")
    public JdbcTemplate barJdbcTemplate(@Qualifier("barDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
