/*
 * Copyright © 2017-2018 All Rights Reserved
 * 上海仰空网络科技有限公司 版权所有
 */

package org.chw.core.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;

/**
 * @className BloomFilterUtil
 * @description
 */
public class BloomFilterUtil {

  public static void main(String[] args) {
    BloomFilter<String> stringBloomFilter =
        BloomFilter.create((Funnel<String>) (o, primitiveSink) -> {
          primitiveSink.putString(o, Charsets.UTF_8);
        }, 1024 * 1024 * 32);
    stringBloomFilter.put("s");
    if (stringBloomFilter.mightContain("a")) {
      System.out.println("aaa");
    }
  }



}
