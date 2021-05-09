package com.example.mallproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 1.整合Redis
 *      1.)引入依赖：spring-boot-starter-data-redis
 *      2.)配置文件中配置host、port、username、password等
 *      3.)使用SpringBoot根据配置文件自动帮我们配置好并纳入容器的RedisTemplate实例来操作Redis
 *          3.1)找自动配置类的方法：一般都是以xxxAutoConfiguration命名
 *      4.)无论是Lettuce还是Jedis都是操作Redis的底层客户端，RedisTemplate是SpringBoot对底层客户端的再次封装
 *
 * 2.Redis做分布式锁（自制版）
 *      1.)脚本示例：set lock aaa ex 300 nx，表示设置key为lock，value为aaa，过期时间300s，如果不存在这个key就设置，存在就不设置
 *      2.)加锁和设置过期时间必须是原子操作
 *      3.)获取值对比和删除锁也必须是原子操作，使用lua脚本
 *
 * 3.Redis做分布式锁（使用Redisson，Redisson也是封装了Redis，并提供了更强大的功能）
 *      官方文档：https://github.com/redisson/redisson/wiki/Table-of-Content
 *      1.)引入依赖
 *      2.)配置
 *
 * 4.缓存数据一致性
 *      1.)双写模式：数据库更新，缓存也更新
 *      2.)失效模式：数据库更新，缓存直接删除。那么下一次查询会查库，然后重新写入缓存。
 *      3.)以上两种模式在高并发下都会产生缓存脏数据，所以解决方案是：
 *          1。所有缓存都设置过期时间，可以保证数据最终一致
 *          2。读写数据的时候，加上分布式读写锁（适用读多写少的场景，如果是写多的场景性能会很差）
 *
 * 5.使用SpringCache组件，简化缓存开发
 *      官方文档：https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#cache
 *      1.)引入依赖：spring-boot-starter-data-redis、spring-boot-starter-cache
 *      2.)配置：
 *          1。已经自动配置的：
 *              CacheAutoConfiguration里导入了RedisCacheConfiguration，自动配置了RedisCacheManager
 *          2。我们要配置的：
 *              配置SpringCache的类型：spring.cache.type=redis
 *          3。常用注解：
 *              @Cacheable: Triggers cache population.
 *              触发将数据保存到缓存
 *              @CacheEvict: Triggers cache eviction.
 *              触发将数据从缓存中删除
 *              @CachePut: Updates the cache without interfering with the method execution.
 *              在不影响方法执行的情况下更新缓存
 *              @Caching: Regroups multiple cache operations to be applied on a method.
 *              重新组合要在方法上应用的多个缓存操作
 *              @CacheConfig: Shares some common cache-related settings at class-level.
 *              在类级别共享一些与缓存相关的常见设置
 *          4。使用步骤：
 *              1。）已经配置好相关配置
 *              2。）开启缓存：在主启动类上使用注解：@EnableCaching
 *              3。）在方法上使用以上常用注解
 *
 *
 *
 *
 *
 */

@EnableCaching
@MapperScan("com.example.mallproduct.dao")
@SpringBootApplication
public class MallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }

}
