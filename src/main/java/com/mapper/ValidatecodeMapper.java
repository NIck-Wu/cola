package com.mapper;

import com.entity.Validatecode;

public interface ValidatecodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Validatecode record);

    int insertSelective(Validatecode record);

    Validatecode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Validatecode record);

    int updateByPrimaryKey(Validatecode record);
}