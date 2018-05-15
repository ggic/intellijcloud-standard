package com.intellijcloud.standard.app.service;

import com.intellijcloud.standard.api.AppApi;
import com.intellijcloud.standard.api.dto.request.AppRequest;
import com.intellijcloud.standard.api.dto.response.AppResponse;
import org.springframework.stereotype.Service;

/**
 * Created by Patrick on 2018/5/15.
 */
@Service
public class AppService implements AppApi {

    @Override
    public AppResponse doSome(AppRequest request) {
        return new AppResponse();
    }
}
