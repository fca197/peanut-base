package com.olivia.peanut.base.api.entity.baseReportConfig;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 报表配置(BaseReportConfig)根据ID删除多个反参
 *
 * @author makejava
 * @since 2025-03-29 12:32:11
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigDeleteByIdListRes {
  /***
   * 受影响行数
   */
  private int count;

}

