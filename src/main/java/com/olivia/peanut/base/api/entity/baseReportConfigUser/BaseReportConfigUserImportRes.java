package com.olivia.peanut.base.api.entity.baseReportConfigUser;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 报表配置用户配置(BaseReportConfigUser)保存返回
 *
 * @author makejava
 * @since 2025-03-29 15:59:28
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigUserImportRes {

  /****
   * 写入行数
   */
  private int count;
  /**
   * 错误信息
   */
  private List<String> errorMsg;
}

