package com.olivia.peanut.base.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.olivia.peanut.base.api.entity.baseReportConfig.*;
import com.olivia.peanut.base.converter.BaseReportConfigConverter;
import com.olivia.peanut.base.mapper.BaseReportConfigMapper;
import com.olivia.peanut.base.model.BaseReportConfig;
import com.olivia.peanut.base.service.BaseReportConfigService;
import com.olivia.peanut.base.service.BaseTableHeaderService;
import com.olivia.sdk.service.SetNameService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.LambdaQueryUtil;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 报表配置(BaseReportConfig)表服务实现类
 *
 * @author makejava
 * @since 2025-03-29 12:32:12
 */
@Service("baseReportConfigService")
@Transactional
public class BaseReportConfigServiceImpl extends MPJBaseServiceImpl<BaseReportConfigMapper, BaseReportConfig> implements BaseReportConfigService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override BaseReportConfigQueryListRes queryList(BaseReportConfigQueryListReq req) {

    MPJLambdaWrapper<BaseReportConfig> q = getWrapper(req.getData());
    List<BaseReportConfig> list = this.list(q);

    List<BaseReportConfigDto> dataList = BaseReportConfigConverter.INSTANCE.queryListRes(list);
    ((BaseReportConfigService) AopContext.currentProxy()).setName(dataList);
    return new BaseReportConfigQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<BaseReportConfigExportQueryPageListInfoRes> queryPageList(BaseReportConfigExportQueryPageListReq req) {

    DynamicsPage<BaseReportConfig> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<BaseReportConfig> q = getWrapper(req.getData());
    List<BaseReportConfigExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<BaseReportConfig> list = this.page(page, q);
      IPage<BaseReportConfigExportQueryPageListInfoRes> dataList = list.convert(t -> $.copy(t, BaseReportConfigExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = BaseReportConfigConverter.INSTANCE.queryPageListRes(this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((BaseReportConfigService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends BaseReportConfigDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<BaseReportConfig> getWrapper(BaseReportConfigDto obj) {
    MPJLambdaWrapper<BaseReportConfig> q = new MPJLambdaWrapper<>();

    LambdaQueryUtil.lambdaQueryWrapper(q, obj, BaseReportConfig.class
        // 查询条件
        , BaseReportConfig::getReportName //
        , BaseReportConfig::getReportUrl //
    );

    q.orderByDesc(BaseReportConfig::getId);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<BaseReportConfig> page) {

    tableHeaderService.listByBizKey(page, "BaseReportConfigService#queryPageList");

  }


}

