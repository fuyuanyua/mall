package com.example.mallproduct;

import com.example.mallproduct.entity.BrandEntity;
import com.example.mallproduct.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.UUID;

@SpringBootTest
@Slf4j
class MallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("test");
        brandService.save(brandEntity);
        log.info("success");
    }

    @Test
    public void testStringRedisTemplate() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String key = UUID.randomUUID().toString();
        // 存数据
        operations.set(key, "hello world");

        // 取数据
        String value = operations.get(key);
        log.info("value is '{}'", value);

    }

}
