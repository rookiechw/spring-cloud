/*
 * Copyright © 2017-2018 All Rights Reserved
 * 上海仰空网络科技有限公司 版权所有
 */

package org.chw.provider.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

/**
 * @className RedisTests
 * @description
 */
@Component
public class RedisTests {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;


  public void add(String key, String value) {
    this.stringRedisTemplate.opsForValue().append("key_test_s_add", "chenhongwei");
    String status = this.stringRedisTemplate.execute((RedisCallback<String>) redisConnection -> {
      Boolean b = redisConnection.set(key.getBytes(), value.getBytes(),
          Expiration.from(1L, TimeUnit.MICROSECONDS), RedisStringCommands.SetOption.SET_IF_ABSENT);
      return b ? "ok" : "no";
    });

  }
}
