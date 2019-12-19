package com.corereach.communication.wechatbackstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/19 11:24
 * @Version V1.0
 **/
@RestController
public class HelloController {

    @GetMapping("/l")
    private String hello(){
        return "hello langxin-----------";
    }

}
