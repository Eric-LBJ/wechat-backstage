package com.corereach.communication.wechatbackstage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ga.zhang
 */
@SpringBootApplication
@ComponentScan({"org.n3r.idworker"})
public class WechatBackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatBackstageApplication.class, args);
    }

}
