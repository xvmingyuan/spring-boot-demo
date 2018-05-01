package com.cn.controller;/**
 * @Description: Created by xpl on 2018-05-01 13:23.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by xpl on 2018-05-01 13:23
 **/

@RestController
public class HelloController {

    @RequestMapping("/getThymeleaf")
    public ModelAndView getThymeleaf() {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addAllObjects(new HashMap<String, String>(){
            {
                this.put("name","Andy");
            }
        });
        return modelAndView;
    }

}
