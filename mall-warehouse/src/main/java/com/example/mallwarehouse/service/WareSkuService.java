package com.example.mallwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallwarehouse.entity.WareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author lhb
 * @email 
 * @date 2021-03-31 22:21:02
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

