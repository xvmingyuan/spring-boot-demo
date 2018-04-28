package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: spring-boot-example
 * @description: 启动类
 * @author:
 * @create: 2018-04-28 10:42
 **/
@SpringBootApplication
public class HelloApplication {

    /**
     * @Description:
     * @Param: [Class]  配置类源类
     * @Param: [args]   应用启动参数
     * @return: void
     * @Author:
     * @Date: 2018/4/28
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
