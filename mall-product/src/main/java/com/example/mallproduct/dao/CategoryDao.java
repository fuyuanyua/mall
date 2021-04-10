package com.example.mallproduct.dao;

import com.example.mallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品三级分类
 * 
 * @author lhb
 * @email 
 * @date 2021-03-30 12:56:57
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {

    /**
     * 查询所有分类并以树型结构展示（在MyBatis里递归查询）
     * @return
     */
    List<CategoryEntity> listWithTree();
	
}
