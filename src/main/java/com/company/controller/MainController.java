package com.company.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    Log log= LogFactory.getLog(this.getClass());
    @RequestMapping(value="/")
    public String test(){
        System.out.println("go mainPage");
        log.info("go mainPage abc?");
        return "main";
    }

}
