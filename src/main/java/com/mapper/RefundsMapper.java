package com.mapper;

import com.entity.Refunds;

public interface RefundsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Refunds record);

    int insertSelective(Refunds record);

    Refunds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Refunds record);

    int updateByPrimaryKey(Refunds record);
}