package com.olivia.peanut.base.api.entity.baseReportConfig;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 报表配置(BaseReportConfig)保存入参
 *
 * @author makejava
 * @since 2025-03-29 12:32:10
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigInsertReq extends BaseReportConfigDto {

  public void checkParam() {
  }
}

