package com.mapper;

import com.entity.Travelcost;

public interface TravelcostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Travelcost record);

    int insertSelective(Travelcost record);

    Travelcost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Travelcost record);

    int updateByPrimaryKey(Travelcost record);
}