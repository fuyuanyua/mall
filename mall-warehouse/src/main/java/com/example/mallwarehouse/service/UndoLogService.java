package com.example.mallwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallwarehouse.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author lhb
 * @email 
 * @date 2021-03-31 22:21:02
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

