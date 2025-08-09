package com.olivia.peanut.base.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 报表配置(BaseReportConfig)表实体类
 *
 * @author makejava
 * @since 2025-03-29 12:32:12
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("base_report_config")
public class BaseReportConfig extends BaseEntity<BaseReportConfig> {

  /***
   *  报表名称
   */
  private String reportName;
  /***
   *  报表路径
   */
  private String reportUrl;

}

