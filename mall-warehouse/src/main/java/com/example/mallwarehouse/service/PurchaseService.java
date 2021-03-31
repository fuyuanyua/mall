package com.example.mallwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallwarehouse.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author lhb
 * @email 
 * @date 2021-03-31 22:21:02
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

