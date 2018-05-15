package com.intellijcloud.standard.infrastruc.dal.core;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 多数据源执行器
 * Created by Patrick on 15/01/2018.
 */
public class MutiDsDmlExecutor implements DmlExecutor {
    private Collection<JdbcTemplate> jdbcTemplateList;

    public MutiDsDmlExecutor(Collection<JdbcTemplate> jdbcTemplateList) {
        this.jdbcTemplateList = jdbcTemplateList;
    }

    @Override
    public <T> List<T> queryForList(String sql, Class<T> clazzType,Map<String, String> params) {
        for(JdbcTemplate jdbcTemplate:jdbcTemplateList){
          jdbcTemplate.queryForList(sql, clazzType, params);
            //TODO 合并结果集

        }
//        TableMergeTool.merge(null,null,null);
        return  null;
    }

}
