package com.example.mallsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@Slf4j
@SpringBootTest
class MallSearchApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() {
    }

    /**
     * 测试存储数据到es
     */
    @Test
    public void indexData() throws IOException {
        User user = new User();
        user.setUsername("小白").setAge(18).setGender(2);
        String jsonString = JSON.toJSONString(user);
        IndexRequest indexRequest = new IndexRequest("user");
        indexRequest.id("1");
        indexRequest.source(jsonString, XContentType.JSON);

        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        log.info("{}", indexResponse);
    }

    @Data
    @Accessors(chain = true)
    class User {
        private String username;

        private Integer age;

        private Integer gender;
    }



}
