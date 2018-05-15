package com.intellijcloud.standard.infrastruc.dal.mapper;

import com.intellijcloud.standard.infrastruc.dal.dataObject.ConfigDO;

public interface ConfigDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ConfigDO record);

    int insertSelective(ConfigDO record);

    ConfigDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ConfigDO record);

    int updateByPrimaryKey(ConfigDO record);
}