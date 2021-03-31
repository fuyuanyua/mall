package com.example.mallmember.dao;

import com.example.mallmember.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author lhb
 * @email 
 * @date 2021-03-31 22:18:33
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
