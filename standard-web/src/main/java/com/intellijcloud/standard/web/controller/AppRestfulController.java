package com.intellijcloud.standard.web.controller;


import com.intellijcloud.standard.api.AppApi;
import com.intellijcloud.standard.api.dto.BaseResp;
import com.intellijcloud.standard.api.dto.request.AppRequest;
import com.intellijcloud.standard.api.dto.ConfigDTO;
import com.intellijcloud.standard.infrastruc.utils.LogWorker;
import com.intellijcloud.standard.web.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Created by patrick on 2015/6/17.
 */
@RestController
@Slf4j
public class AppRestfulController {
    @Resource
    AppApi appApi;
    @RequestMapping(value = "/config/{id}", method = RequestMethod.GET)
    public ResultDTO getConfig(@PathVariable String id)  {
        LogWorker.logStart(log,"配置","id:{}",id);
        AppRequest request = new AppRequest();
        request.setId(id);
        BaseResp<ConfigDTO> config = appApi.getConfig(request);
        ResultDTO resp = ResultDTO.createSuccess(config);
        LogWorker.logEnd(log,"配置","resp:{}",resp);
        return resp;
    }
}