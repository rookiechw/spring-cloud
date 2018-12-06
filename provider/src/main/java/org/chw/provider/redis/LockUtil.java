/*
 * Copyright © 2017-2018 All Rights Reserved
 * 上海仰空网络科技有限公司 版权所有
 */

package org.chw.provider.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @className LockUtil
 * @description
 */
@Component
public class LockUtil {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  public void getLock(){

  }

}
