package com.cn.common.redis;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-16 15:15
 **/
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisConfigurationProperties {

    private List<String> nodes = new ArrayList<>();

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
