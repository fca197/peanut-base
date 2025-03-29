package com.olivia.peanut.base.api.entity.baseReportConfig;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 报表配置(BaseReportConfig)保存返回
 *
 * @author makejava
 * @since 2025-03-29 12:32:11
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigInsertRes {
  /****
   * 写入行数
   */
  private int count;

  private Long id;
}

