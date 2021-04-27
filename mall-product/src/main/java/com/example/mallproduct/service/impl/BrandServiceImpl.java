package com.example.mallproduct.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.mallproduct.dao.BrandDao;
import com.example.mallproduct.entity.BrandEntity;
import com.example.mallproduct.service.BrandService;
import org.springframework.util.CollectionUtils;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        // 如果查全量数据，走缓存
        if (CollectionUtils.isEmpty(params)) {
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            // 查缓存
            String all = operations.get("all");
            // 缓存中未查到
            if (StringUtils.isEmpty(all)) {
                // 查库
                PageUtils pageUtils = queryPageFromDB(params);
                String jsonString = JSON.toJSONString(pageUtils);
                // 保存数据到redis
                operations.set("all", jsonString);
                return pageUtils;
            }
            // 缓存中查到
            PageUtils pageUtils = JSON.parseObject(all, PageUtils.class);
            return pageUtils;
        }
        // 查分页数据走DB
        return queryPageFromDB(params);
    }

    public PageUtils queryPageFromDB(Map<String, Object> params) {
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                new QueryWrapper<BrandEntity>()
        );

        return new PageUtils(page);
    }

}