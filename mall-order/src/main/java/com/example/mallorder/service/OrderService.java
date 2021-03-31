package com.example.mallorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallorder.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author lhb
 * @email 
 * @date 2021-03-31 22:19:33
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

