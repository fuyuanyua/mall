package com.example.mallwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallwarehouse.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author lhb
 * @email 
 * @date 2021-03-31 22:21:02
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

