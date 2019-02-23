package com.mapper;

import com.entity.Drive;

public interface DriveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Drive record);

    int insertSelective(Drive record);

    Drive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Drive record);

    int updateByPrimaryKey(Drive record);
}