package com.olivia.peanut.base.api.entity.baseReportConfigUser;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 报表配置用户配置(BaseReportConfigUser)根据ID删除多个反参
 *
 * @author makejava
 * @since 2025-03-29 15:59:26
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigUserDeleteByIdListRes {

  /***
   * 受影响行数
   */
  private int count;

}

