package com.olivia.peanut.base.api.entity.baseReportConfigUser;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 报表配置用户配置(BaseReportConfigUser)查询对象返回
 *
 * @author makejava
 * @since 2025-03-29 15:59:28
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigUserQueryByIdListRes {
  /***
   * 返回对象列表
   */
  private List<BaseReportConfigUserDto> dataList;


}

