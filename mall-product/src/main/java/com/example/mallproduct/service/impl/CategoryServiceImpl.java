package com.example.mallproduct.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.mallproduct.dao.CategoryDao;
import com.example.mallproduct.entity.CategoryEntity;
import com.example.mallproduct.service.CategoryService;


@Slf4j
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * @Cacheable
     *      1。该注解表示需要将方法返回结果存入缓存：
     *          若缓存中有记录，不调用方法，直接返回结果；
     *          若缓存中没有记录，则调用方法，然后将结果存入缓存
     *      2。并指定了缓存名称为category（逻辑上的分区，推荐按照业务来划分）
     *      3。默认行为：
     *          默认缓存的key：自动生成，格式：category::SimpleKey []
     *          默认缓存的value：是jdk序列化后的值
     *          默认的ttl：-1，即永不过期（ttl永不过期不符合缓存一致性要求，所以我们需要手动设置过期时间）
     *      4。自定义操作：
     *          自定义key：
     *              使用SpEL（Spring表达式语言）表达式指定
     *              参考：https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#cache-spel-context
     *          自定义ttl：在配置文件中配置：spring.cache.redis.time-to-live=3600000，单位ms
     *          自定义序列化机制：参考自定义配置
     *
     * @return
     */
    @Cacheable(cacheNames = "category", key = "#root.method.name")
    @Override
    public List<CategoryEntity> listWithTree() {
        log.info("方法被调用。。。");
        List<CategoryEntity> categoryEntities = baseMapper.listWithTree();
        return categoryEntities;
    }

    /**
     * @CacheEvict
     *      1。该注解用于删除缓存
     *      2。所以用于失效模式
     * @param categoryEntity
     */
    @CacheEvict(cacheNames = "category", key = "'listWithTree'")
    @Override
    public void update(CategoryEntity categoryEntity) {
        this.updateById(categoryEntity);
    }


}