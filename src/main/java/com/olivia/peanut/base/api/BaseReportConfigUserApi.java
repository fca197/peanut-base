package com.olivia.peanut.base.api;

import org.springframework.validation.annotation.Validated;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.olivia.peanut.base.api.entity.baseReportConfigUser.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * 报表配置用户配置(BaseReportConfigUser)对外API
 *
 * @author makejava
 * @since 2025-03-29 15:59:26
 */
// @FeignClient(value = "",contextId = "baseReportConfigUser-api",url = "${ portal..center.endpoint:}")
public interface BaseReportConfigUserApi {

  /**
   * 保存 报表配置用户配置
   */
  @PostMapping("/baseReportConfigUser/insert")
  BaseReportConfigUserInsertRes insert(@RequestBody @Validated(InsertCheck.class) BaseReportConfigUserInsertReq req);

  /**
   * 根据ID 删除 报表配置用户配置
   */
  @PostMapping("/baseReportConfigUser/deleteByIdList")
  BaseReportConfigUserDeleteByIdListRes deleteByIdList(@RequestBody @Valid BaseReportConfigUserDeleteByIdListReq req);

  /**
   * 查询 报表配置用户配置
   */
  @PostMapping("/baseReportConfigUser/queryList")
  BaseReportConfigUserQueryListRes queryList(@RequestBody @Valid BaseReportConfigUserQueryListReq req);

  /**
   * 根据ID 更新 报表配置用户配置
   */
  @PostMapping("/baseReportConfigUser/updateById")
  BaseReportConfigUserUpdateByIdRes updateById(@RequestBody @Validated(UpdateCheck.class) BaseReportConfigUserUpdateByIdReq req);

  /**
   * 分页查询 报表配置用户配置
   */
  @PostMapping("/baseReportConfigUser/queryPageList")
  DynamicsPage<BaseReportConfigUserExportQueryPageListInfoRes> queryPageList(@RequestBody @Valid BaseReportConfigUserExportQueryPageListReq req);
  @PostMapping("/baseReportConfigUser/queryPageList/self")
  DynamicsPage<BaseReportConfigUserExportQueryPageListInfoRes> queryPageListSelf(@RequestBody @Valid BaseReportConfigUserExportQueryPageListReq req);

  /**
   * 导出 报表配置用户配置
   */
  @PostMapping("/baseReportConfigUser/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid BaseReportConfigUserExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/baseReportConfigUser/importData")
  BaseReportConfigUserImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/baseReportConfigUser/queryByIdList")
  BaseReportConfigUserQueryByIdListRes queryByIdListRes(@RequestBody @Valid BaseReportConfigUserQueryByIdListReq req);


}
