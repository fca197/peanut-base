package com.olivia.peanut.base.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.base.api.entity.factory.*;
import com.olivia.peanut.base.model.Factory;
import com.olivia.sdk.utils.DynamicsPage;

/**
 * 工段信息(Factory)表服务接口
 *
 * @author makejava
 * @since 2024-03-11 10:44:05
 */
public interface FactoryService extends MPJBaseService<Factory> {

  FactoryQueryListRes queryList(FactoryQueryListReq req);

  DynamicsPage<FactoryExportQueryPageListInfoRes> queryPageList(FactoryExportQueryPageListReq req);

}

