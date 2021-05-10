package com.example.mallproduct.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: ThreadPoolProperties
 * @Author: lhb
 * @Date: 2021/5/10 21:06
 */

@Data
@Component
@ConfigurationProperties(prefix = "mall.thread-pool")
public class ThreadPoolProperties {

    /**
     * 核心线程数
     */
    private Integer corePoolSize;

    /**
     * 最大线程数
     */
    private Integer maximumPoolSize;

    /**
     * 除核心线程外其他线程的最大存活时间
     */
    private Long keepAliveTime;
}
