/*
 * Copyright © 2017-2018 All Rights Reserved
 * 上海仰空网络科技有限公司 版权所有
 */

package org.chw.provider.redis;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

/**
 * @className MyLock
 * @description
 */
public class MyLock {
  private String key;
  private String uuid;
  private final Logger LOGGER = LoggerFactory.getLogger(MyLock.class);

  MyLock(String key, String uuid) {
    this.key = key;
    this.uuid = uuid;
  }

  public void unLock(StringRedisTemplate stringRedisTemplate) {
    List<String> keys = Collections.singletonList(key);
    String script =
        "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end ";
    DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
    redisScript.setScriptText(script);
    redisScript.setResultType(Long.class);
    Long result = stringRedisTemplate.execute(redisScript, keys, uuid);
    if (null != result) {
      LOGGER.info(result.toString());
    }
  }
}
