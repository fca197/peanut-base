package com.olivia.peanut.base.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.base.api.entity.baseReportConfigUser.*;
import com.olivia.peanut.base.model.BaseReportConfigUser;
import com.olivia.sdk.utils.DynamicsPage;
import java.util.List;

/**
 * 报表配置用户配置(BaseReportConfigUser)表服务接口
 *
 * @author makejava
 * @since 2025-03-29 15:59:28
 */
public interface BaseReportConfigUserService extends MPJBaseService<BaseReportConfigUser> {

  BaseReportConfigUserQueryListRes queryList(BaseReportConfigUserQueryListReq req);

  DynamicsPage<BaseReportConfigUserExportQueryPageListInfoRes> queryPageList(BaseReportConfigUserExportQueryPageListReq req);


  void setName(List<? extends BaseReportConfigUserDto> baseReportConfigUserDtoList);
}

