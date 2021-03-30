package com.example.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallproduct.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author lhb
 * @email 
 * @date 2021-03-30 12:56:56
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

