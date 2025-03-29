package com.olivia.peanut.base.api.entity.baseReportConfig;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 报表配置(BaseReportConfig)查询对象入参
 *
 * @author makejava
 * @since 2025-03-29 12:32:13
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigQueryByIdListReq {
  private List<Long> idList;

}

