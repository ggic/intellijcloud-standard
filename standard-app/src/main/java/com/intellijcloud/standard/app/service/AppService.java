package com.intellijcloud.standard.app.service;

import com.intellijcloud.standard.api.AppApi;
import com.intellijcloud.standard.api.dto.BaseResp;
import com.intellijcloud.standard.api.dto.request.AppRequest;
import com.intellijcloud.standard.api.dto.ConfigDTO;
import com.intellijcloud.standard.app.utils.ValidateUtils;
import com.intellijcloud.standard.infrastruc.dal.dataObject.ConfigDO;
import com.intellijcloud.standard.infrastruc.dal.mapperExt.ConfigDOMapperExt;
import com.intellijcloud.standard.infrastruc.utils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Patrick on 2018/5/15.
 */
@Service
public class AppService implements AppApi {
    @Resource
    ConfigDOMapperExt configDOMapperExt;
    @Override
    public BaseResp<ConfigDTO> getConfig(AppRequest request) {
        BaseResp<ConfigDTO> baseResp = null;
        try {
            ValidateUtils.fail4Null(request, "request");
            ValidateUtils.fail4Null(request.getId(), "request ID");
            ConfigDO configDO = configDOMapperExt.selectByPrimaryKey(Long.valueOf(request.getId()));
            ConfigDTO configDTO = BeanUtils.copy(configDO, new ConfigDTO());
            BaseResp.createSuccess(configDTO);
        }catch (Exception e){
            baseResp =BaseResp.createFailure(e.getMessage());
        }
        return baseResp;
    }
}
