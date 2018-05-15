package com.intellijcloud.standard.infrastruc.dal.core;


import java.util.List;
import java.util.Map;

/**
 * 数据库dml执行器
 * Created by Patrick on 11/01/2018.
 */
public interface DmlExecutor {
    public <T> List<T> queryForList(String sql, Class<T> elementType,Map<String, String> params);

}
