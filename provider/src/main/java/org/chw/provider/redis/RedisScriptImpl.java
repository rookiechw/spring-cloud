/*
 * Copyright © 2017-2018 All Rights Reserved
 * 上海仰空网络科技有限公司 版权所有
 */

package org.chw.provider.redis;

import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.lang.NonNull;

/**
 * @className RedisScriptImpl
 * @description
 */
public class RedisScriptImpl implements RedisScript {
  private java.lang.String script =
      "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

  @Override
  @NonNull
  public String getSha1() {
    return DigestUtils.sha1DigestAsHex(script);
  }

  @Override
  public Class<RedisScriptImpl> getResultType() {
    return RedisScriptImpl.class;
  }

  @Override
  @NonNull
  public String getScriptAsString() {
    return script;
  }
}
