package com.mapper;

import com.entity.Airlines;

public interface AirlinesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Airlines record);

    int insertSelective(Airlines record);

    Airlines selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Airlines record);

    int updateByPrimaryKey(Airlines record);
}