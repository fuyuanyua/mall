package com.example.mallproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.整合redis
 *      1.)引入spring-boot-starter-data-redis依赖
 *      2.)配置文件中配置host、port、username、password等
 *      3.)使用SpringBoot根据配置文件自动帮我们配置好并纳入容器的RedisTemplate实例来操作redis
 */

@MapperScan("com.example.mallproduct.dao")
@SpringBootApplication
public class MallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }

}
