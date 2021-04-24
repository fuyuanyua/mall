package com.example.mallsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ElasticSearch相关微服务
 * 1.导入依赖：elasticsearch-rest-high-level-client
 * 2.编写配置类，向容器中注入RestHighLevelClient实例
 * 3.参照官方api操作：https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-supported-apis.html
 */

@SpringBootApplication
public class MallSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSearchApplication.class, args);
    }

}
