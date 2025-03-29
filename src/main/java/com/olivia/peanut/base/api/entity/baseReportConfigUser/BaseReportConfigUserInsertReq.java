package com.olivia.peanut.base.api.entity.baseReportConfigUser;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 报表配置用户配置(BaseReportConfigUser)保存入参
 *
 * @author makejava
 * @since 2025-03-29 15:59:26
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigUserInsertReq extends BaseReportConfigUserDto {

  public void checkParam() {
  }
}

