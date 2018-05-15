package com.intellijcloud.standard.infrastruc.dal.core;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 默认执行器
 * Created by Patrick on 15/01/2018.
 */
public class DefaultDmlExecutor implements DmlExecutor {
    private JdbcTemplate jdbcTemplate;

    public DefaultDmlExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <T> List<T> queryForList(String sql, Class<T> clazzType,Map<String, String> params) {
        return jdbcTemplate.queryForList(sql,clazzType,params);
    }

}
