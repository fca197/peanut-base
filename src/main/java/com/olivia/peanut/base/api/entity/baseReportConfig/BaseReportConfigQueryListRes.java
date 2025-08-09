package com.olivia.peanut.base.api.entity.baseReportConfig;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 报表配置(BaseReportConfig)查询对象返回
 *
 * @author makejava
 * @since 2025-03-29 12:32:11
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigQueryListRes {

  /***
   * 返回对象列表
   */
  private List<BaseReportConfigDto> dataList;


}

