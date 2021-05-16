package com.example.mallproduct;

import com.auth0.jwt.JWTCreator;
import com.example.mallproduct.entity.BrandEntity;
import com.example.mallproduct.service.BrandService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@SpringBootTest
@Slf4j
class MallProductApplicationTests {

    /**
     * token过期时间，24小时
     */
    private static final long TOKEN_EXPIRATION = 1000 * 60 * 60 * 24;

    /**
     * token生效时间，10秒种之后
     */
    private static final long TOKEN_NOT_BEFORE = 1000 * 10;

    /**
     * 签名
     */
    private static final String TOKEN_SIGN_KEY = "dsdadaadadadada";

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

    /**
     * 测试Redis
     */
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

    /**
     * 测试生成Token
     */
    @Test
    public void testCreatToken() {
        JwtBuilder jwtBuilder = Jwts.builder();
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String token = jwtBuilder
                // 头
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")

                // 载荷-自定义信息部分
                .claim("name", "lhb")
                .claim("age", 25)

                // 载荷-默认信息部分
                .setSubject("user") // 令牌主题
                .setIssuer("lhb") // 签发者
                .setAudience("lhb") // 接收方
                .setIssuedAt(new Date()) // 令牌签发时间
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION)) // 令牌过期时间
                .setNotBefore(new Date(System.currentTimeMillis() + TOKEN_NOT_BEFORE)) // 令牌生效时间
                .setId(UUID.randomUUID().toString()) // 令牌唯一标识

                // 签名
                .signWith(key)

                .compact();

        log.info("token:{}", token);
    }

}
