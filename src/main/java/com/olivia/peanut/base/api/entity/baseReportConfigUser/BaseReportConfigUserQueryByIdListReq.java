package com.olivia.peanut.base.api.entity.baseReportConfigUser;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 报表配置用户配置(BaseReportConfigUser)查询对象入参
 *
 * @author makejava
 * @since 2025-03-29 15:59:28
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigUserQueryByIdListReq {
  private List<Long> idList;

}

