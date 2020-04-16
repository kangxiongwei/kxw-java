package com.kxw.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动spring-boot项目
 *
 * @author kangxiongwei
 * @date 2020-04-16 17:12
 */
@SpringBootApplication
@RestController
public class SpringBootApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootApp.class);

    /**
     * 启动springboot主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
        LOGGER.info("服务已启动...");
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

}
