package com.intellijcloud.standard.api;

import com.intellijcloud.standard.api.dto.response.BaseResp;
import com.intellijcloud.standard.api.dto.request.AppRequest;
import com.intellijcloud.standard.api.dto.ConfigDTO;

/**
 * Created by Patrick on 2018/5/15.
 */
public interface AppApi {
    public BaseResp<ConfigDTO> getConfig(AppRequest request);
}
