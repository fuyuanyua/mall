package com.example.mallmember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.mallmember.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author lhb
 * @email 
 * @date 2021-03-31 22:18:33
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

