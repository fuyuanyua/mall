package com.example.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallproduct.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author lhb
 * @email 
 * @date 2021-03-30 12:56:57
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询所有分类并以树型结构展示（在MyBatis里递归查询）
     * @return
     */
    List<CategoryEntity> listWithTree();

    /**
     * 更新单个分类
     * @param categoryEntity
     */
    void update(CategoryEntity categoryEntity);
}

