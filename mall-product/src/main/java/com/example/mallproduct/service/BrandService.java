package com.example.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallproduct.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author lhb
 * @email 
 * @date 2021-03-30 12:56:57
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

