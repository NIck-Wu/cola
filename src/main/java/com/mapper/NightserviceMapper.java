package com.mapper;

import com.entity.Nightservice;

public interface NightserviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nightservice record);

    int insertSelective(Nightservice record);

    Nightservice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nightservice record);

    int updateByPrimaryKey(Nightservice record);
}