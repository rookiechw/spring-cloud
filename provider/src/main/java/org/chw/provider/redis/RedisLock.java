/*
 * Copyright © 2017-2018 All Rights Reserved
 * 上海仰空网络科技有限公司 版权所有
 */

package org.chw.provider.redis;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @className RedisLock
 * @description
 */
@Component
public class RedisLock<K, V> {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private RedisTemplate<K, V> redisTemplate;


  public MyLock getLock(String key, Long expr) {
    String uuid = UUID.randomUUID().toString().replace("-", "");
    uuid = uuid + "-" + expr;
    Boolean b = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid);
    if (Objects.equals(b, Boolean.TRUE)) {
      return new MyLock(key, uuid);
    }
    return null;
  }

  public Set<V> getValue(K key) {
    SetOperations<K, V> operations = redisTemplate.opsForSet();
    return operations.members(key);
  }

  public void addValue(String key,String value){
      stringRedisTemplate.opsForSet().add(key,value);
  }
  public void setValue(K key, V value) {
    SetOperations<K, V> operations = redisTemplate.opsForSet();
    operations.add(key, value);
  }
}
