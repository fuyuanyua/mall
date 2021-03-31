package com.example.mallorder.dao;

import com.example.mallorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author lhb
 * @email 
 * @date 2021-03-31 22:19:33
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
