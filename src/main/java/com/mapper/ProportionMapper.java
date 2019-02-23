package com.mapper;

import com.entity.Proportion;

public interface ProportionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Proportion record);

    int insertSelective(Proportion record);

    Proportion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Proportion record);

    int updateByPrimaryKey(Proportion record);
}