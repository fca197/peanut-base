package com.olivia.peanut.base.api.entity.baseReportConfigUser;

import com.olivia.peanut.portal.api.entity.BaseEntityDto;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
//import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 报表配置用户配置(BaseReportConfigUser)查询对象返回
 *
 * @author makejava
 * @since 2025-03-29 15:59:28
 */
//@Accessors(chain=true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseReportConfigUserDto extends BaseEntityDto {

  /***
   *  报表ID
   */
  //  @JSONField(label = "reportConfigId")
  @NotNull(message = "报表ID不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Long reportConfigId;
  /***
   *  排序
   */
  //  @JSONField(label = "sortIndex")
  @NotNull(message = "排序不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Integer sortIndex;
  /***
   *  宽度 安el-col span 计算
   */
  //  @JSONField(label = "colSpan")
  @NotNull(message = "宽度 安el-col span 计算不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Integer colSpan;
  /***
   *  高度
   */
  //  @JSONField(label = "height")
  @NotNull(message = "高度不能为空", groups = {InsertCheck.class, UpdateCheck.class})

  private Integer height;
  /***
   *  报表名称
   */
  @NotBlank(message = "报表名称不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "reportName")

  private String reportName;
  /***
   *  报表路径
   */
  @NotBlank(message = "报表路径不能为空", groups = {InsertCheck.class, UpdateCheck.class})
  //  @JSONField(label = "reportUrl")

  private String reportUrl;

}


