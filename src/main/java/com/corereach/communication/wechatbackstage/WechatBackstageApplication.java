package com.corereach.communication.wechatbackstage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author ga.zhang
 */
@SpringBootApplication
@ComponentScan({"org.n3r.idworker","com.corereach.communication.wechatbackstage"})
@MapperScan(basePackages="com.corereach.communication.wechatbackstage.dao")
public class WechatBackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatBackstageApplication.class, args);
    }

}
