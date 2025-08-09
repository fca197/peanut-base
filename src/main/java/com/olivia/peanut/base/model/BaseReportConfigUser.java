package com.olivia.peanut.base.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.olivia.sdk.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 报表配置用户配置(BaseReportConfigUser)表实体类
 *
 * @author makejava
 * @since 2025-03-29 15:59:28
 */
@Accessors(chain = true)
@Getter
@Setter
//@SuppressWarnings("serial")
@TableName("base_report_config_user")
public class BaseReportConfigUser extends BaseEntity<BaseReportConfigUser> {

  /***
   *  报表ID
   */
  private Long reportConfigId;
  /***
   *  排序
   */
  private Integer sortIndex;
  /***
   *  宽度 安el-col span 计算
   */
  private Integer colSpan;
  /***
   *  高度
   */
  private Integer height;
  /***
   *  报表名称
   */
  private String reportName;
  /***
   *  报表路径
   */
  private String reportUrl;

}

