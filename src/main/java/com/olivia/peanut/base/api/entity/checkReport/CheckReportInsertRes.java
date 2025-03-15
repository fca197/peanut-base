package com.olivia.peanut.base.api.entity.checkReport;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 报表信息(CheckReport)保存返回
 *
 * @author makejava
 * @since 2024-03-14 13:31:35
 */
@Accessors(chain = true)
@Getter
@Setter

public class CheckReportInsertRes {

  /****
   * 写入行数
   */
  private int count;

  private Long id;
}

