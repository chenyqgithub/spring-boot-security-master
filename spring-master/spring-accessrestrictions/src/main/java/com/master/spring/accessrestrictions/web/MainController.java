package com.master.spring.accessrestrictions.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/5/7.
 */
@RestController
public class MainController {
    @RequestMapping("main")
    public String main(){
        System.out.println("11111");
        return "111";
    }
}
