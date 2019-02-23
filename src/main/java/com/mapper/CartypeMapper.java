package com.mapper;

import com.entity.Cartype;

public interface CartypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cartype record);

    int insertSelective(Cartype record);

    Cartype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cartype record);

    int updateByPrimaryKey(Cartype record);
}