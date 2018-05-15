package com.intellijcloud.standard.api;

import com.intellijcloud.standard.api.dto.request.AppRequest;
import com.intellijcloud.standard.api.dto.response.AppResponse;

/**
 * Created by Patrick on 2018/5/15.
 */
public interface AppApi {
    public AppResponse doSome(AppRequest request);
}
