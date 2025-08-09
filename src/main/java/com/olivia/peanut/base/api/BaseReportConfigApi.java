package com.olivia.peanut.base.api;

import com.olivia.peanut.base.api.entity.baseReportConfig.*;
import com.olivia.sdk.ann.InsertCheck;
import com.olivia.sdk.ann.UpdateCheck;
import com.olivia.sdk.utils.DynamicsPage;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * 报表配置(BaseReportConfig)对外API
 *
 * @author makejava
 * @since 2025-03-29 12:32:10
 */
// @FeignClient(value = "",contextId = "baseReportConfig-api",url = "${ portal..center.endpoint:}")
public interface BaseReportConfigApi {

  /**
   * 保存 报表配置
   */
  @PostMapping("/baseReportConfig/insert")
  BaseReportConfigInsertRes insert(@RequestBody @Validated(InsertCheck.class) BaseReportConfigInsertReq req);

  /**
   * 根据ID 删除 报表配置
   */
  @PostMapping("/baseReportConfig/deleteByIdList")
  BaseReportConfigDeleteByIdListRes deleteByIdList(@RequestBody @Valid BaseReportConfigDeleteByIdListReq req);

  /**
   * 查询 报表配置
   */
  @PostMapping("/baseReportConfig/queryList")
  BaseReportConfigQueryListRes queryList(@RequestBody @Valid BaseReportConfigQueryListReq req);

  /**
   * 根据ID 更新 报表配置
   */
  @PostMapping("/baseReportConfig/updateById")
  BaseReportConfigUpdateByIdRes updateById(@RequestBody @Validated(UpdateCheck.class) BaseReportConfigUpdateByIdReq req);

  /**
   * 分页查询 报表配置
   */
  @PostMapping("/baseReportConfig/queryPageList")
  DynamicsPage<BaseReportConfigExportQueryPageListInfoRes> queryPageList(@RequestBody @Valid BaseReportConfigExportQueryPageListReq req);

  /**
   * 导出 报表配置
   */
  @PostMapping("/baseReportConfig/exportQueryPageList")
  void queryPageListExport(@RequestBody @Valid BaseReportConfigExportQueryPageListReq req);

  /**
   * 导入
   */
  @PostMapping("/baseReportConfig/importData")
  BaseReportConfigImportRes importData(@RequestParam("file") MultipartFile file);


  /**
   * 根据ID 批量查询
   */
  @PostMapping("/baseReportConfig/queryByIdList")
  BaseReportConfigQueryByIdListRes queryByIdListRes(@RequestBody @Valid BaseReportConfigQueryByIdListReq req);


}
