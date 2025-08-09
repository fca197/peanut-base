package com.olivia.peanut.base.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.base.api.entity.tenantInfo.*;
import com.olivia.peanut.base.model.TenantInfo;
import com.olivia.sdk.utils.DynamicsPage;

/**
 * 租户信息(TenantInfo)表服务接口
 *
 * @author makejava
 * @since 2024-03-11 10:55:22
 */
public interface TenantInfoService extends MPJBaseService<TenantInfo> {

  TenantInfoQueryListRes queryList(TenantInfoQueryListReq req);

  DynamicsPage<TenantInfoExportQueryPageListInfoRes> queryPageList(TenantInfoExportQueryPageListReq req);

}

