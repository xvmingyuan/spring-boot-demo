package com.cn.controller;

import com.cn.entity.MyBean;
import com.cn.entity.TestBean;
import com.cn.properties.AcmeProperties;
import com.cn.properties.AppConfig;
import com.cn.properties.Config;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-example
 * @description:
 * @author:
 * @create: 2018-05-18 11:30
 **/
@RestController
public class TestController {

    @Autowired
    private TestBean testBean;

    @Autowired
    private MyBean myBean;

    @Autowired
    private Config config;

    @Autowired
    private AcmeProperties acmeProperties;

    @RequestMapping("/getTestBean")
    public TestBean getTestBean() {
        return testBean;
    }

    @RequestMapping("/getMyBean")
    public MyBean getMyBean() {
        return myBean;
    }

    @RequestMapping("/getList")
    public List<String> getList() {
        return config.getServers();
    }

    @RequestMapping("/getAcme")
    public AcmeProperties getAcme() {
        return acmeProperties;
    }
}
