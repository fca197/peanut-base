package com.olivia.peanut.base.api.entity.baseSupplier;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * (BaseSupplier)保存返回
 *
 * @author peanut
 * @since 2024-03-28 15:35:37
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseSupplierInsertRes {

  /****
   * 写入行数
   */
  private int count;

}

