package com.intellijcloud.standard.domain.dal;

import com.intellijcloud.standard.infrastruc.utils.DateHelper;
import com.intellijcloud.standard.infrastruc.utils.LogWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author pw
 * @date 2017-1-9
 */
@Slf4j
public class RedisTest extends TST {
    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void redisTest() {
        redisTemplate.delete("BIZ1:key-000000000001");
        Object v = redisTemplate.opsForValue().get("ctripbank_monitor:CREDIT_APPLY_PERSON_COUNT-PJ02-20171225");
        LogWorker.log(log,"","取缓存值,{}",v);
     }
}
