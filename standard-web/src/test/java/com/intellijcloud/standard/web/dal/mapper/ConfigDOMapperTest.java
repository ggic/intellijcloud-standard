package com.intellijcloud.standard.web.dal.mapper;

import com.intellijcloud.standard.biz1.app.dal.dataObject.ConfigDO;
import com.intellijcloud.standard.biz1.app.dal.mapperExt.ConfigDOMapperExt;
import com.intellijcloud.standard.web.TST;
import com.intellijcloud.standard.common.utils.LogWorker;
import com.intellijcloud.standard.common.utils.StringHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Patrick on 2018/5/15.
 */
@Slf4j
public class ConfigDOMapperTest extends TST{
    @Resource
    ConfigDOMapperExt configDOMapperExt;
    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsertSelective() throws Exception {

    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        ConfigDO configDO = configDOMapperExt.selectByPrimaryKey(1L);
        LogWorker.log(log,"查询",":{}", StringHelper.json(configDO));
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }

}