package com.intellijcloud.standard.biz1.app.service;


import com.intellijcloud.standard.biz1.api.AppApi;
import com.intellijcloud.standard.biz1.api.dto.ConfigDTO;
import com.intellijcloud.standard.biz1.api.dto.request.AppRequest;
import com.intellijcloud.standard.biz1.api.dto.response.BaseResp;
import com.intellijcloud.standard.biz1.app.dal.dataObject.ConfigDO;
import com.intellijcloud.standard.biz1.app.dal.mapperExt.ConfigDOMapperExt;
import com.intellijcloud.standard.common.utils.BeanUtils;
import com.intellijcloud.standard.common.utils.LogWorker;
import com.intellijcloud.standard.common.utils.ValidateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Patrick on 2018/5/15.
 */
@Service
@Slf4j
public class AppApiImpl implements AppApi {
    @Resource
    ConfigDOMapperExt configDOMapperExt;
    @Override
    public BaseResp<ConfigDTO> getConfig(AppRequest request) {
        BaseResp<ConfigDTO> baseResp = null;
        LogWorker.logEnd(log,"配置查询","request:{}",request);

        try {
            ValidateUtils.fail4Null(request, "request");
            ValidateUtils.fail4Null(request.getId(), "request ID");
            ConfigDO configDO = configDOMapperExt.selectByPrimaryKey(Long.valueOf(request.getId()));
            ConfigDTO configDTO = BeanUtils.copy(configDO, new ConfigDTO());
            baseResp = BaseResp.createSuccess(configDTO);

        }catch (Exception e){
            baseResp = BaseResp.createFailure(e.getMessage());
        }
        LogWorker.logEnd(log,"配置查询","baseResp:{}",baseResp);
        return baseResp;
    }
}
