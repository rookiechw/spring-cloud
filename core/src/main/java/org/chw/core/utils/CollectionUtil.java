/*
 * Copyright © 2017-2018 All Rights Reserved
 * 上海仰空网络科技有限公司 版权所有
 */

package org.chw.core.utils;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

/**
 * @className a
 * @description
 */
public class CollectionUtil {
  public static boolean isEmpty(Collection coll) {
    return CollectionUtils.isEmpty(coll);
  }

  public static boolean isNotEmpty(Collection coll) {
    return CollectionUtils.isNotEmpty(coll);
  }
}
