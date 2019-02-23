package com.mapper;

import com.entity.Gateways;

public interface GatewaysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gateways record);

    int insertSelective(Gateways record);

    Gateways selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gateways record);

    int updateByPrimaryKey(Gateways record);
}