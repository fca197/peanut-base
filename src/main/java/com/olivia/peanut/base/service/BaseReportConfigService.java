package com.olivia.peanut.base.service;

import com.olivia.sdk.utils.DynamicsPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.base.model.BaseReportConfig;

import java.util.List;

import com.github.yulichang.base.MPJBaseService;

import com.olivia.peanut.base.api.entity.baseReportConfig.*;

/**
 * 报表配置(BaseReportConfig)表服务接口
 *
 * @author makejava
 * @since 2025-03-29 12:32:12
 */
public interface BaseReportConfigService extends MPJBaseService<BaseReportConfig> {
  BaseReportConfigQueryListRes queryList(BaseReportConfigQueryListReq req);

  DynamicsPage<BaseReportConfigExportQueryPageListInfoRes> queryPageList(BaseReportConfigExportQueryPageListReq req);


  void setName(List<? extends BaseReportConfigDto> baseReportConfigDtoList);
}

