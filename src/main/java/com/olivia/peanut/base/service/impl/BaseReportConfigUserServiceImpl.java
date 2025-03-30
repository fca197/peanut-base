package com.olivia.peanut.base.service.impl;

import com.olivia.sdk.utils.BaseEntity;
import org.springframework.aop.framework.AopContext;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import jakarta.annotation.Resource;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.LambdaQueryUtil;
import com.olivia.sdk.utils.DynamicsPage;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.olivia.peanut.base.mapper.BaseReportConfigUserMapper;
import com.olivia.peanut.base.model.BaseReportConfigUser;
import com.olivia.peanut.base.converter.BaseReportConfigUserConverter;
import com.olivia.peanut.base.service.BaseReportConfigUserService;
import cn.hutool.core.collection.CollUtil;
import com.olivia.peanut.base.service.BaseTableHeaderService;

import com.olivia.peanut.base.api.entity.baseReportConfigUser.*;
import com.olivia.peanut.util.SetNamePojoUtils;
import com.olivia.sdk.service.SetNameService;

/**
 * 报表配置用户配置(BaseReportConfigUser)表服务实现类
 *
 * @author makejava
 * @since 2025-03-29 15:59:28
 */
@Service("baseReportConfigUserService")
@Transactional
public class BaseReportConfigUserServiceImpl extends MPJBaseServiceImpl<BaseReportConfigUserMapper, BaseReportConfigUser> implements BaseReportConfigUserService {

  final static Cache<String, Map<String, String>> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(30, TimeUnit.MINUTES).build();

  @Resource
  BaseTableHeaderService tableHeaderService;
  @Resource
  SetNameService setNameService;


  public @Override BaseReportConfigUserQueryListRes queryList(BaseReportConfigUserQueryListReq req) {

    MPJLambdaWrapper<BaseReportConfigUser> q = getWrapper(req.getData());
    List<BaseReportConfigUser> list = this.list(q);

    List<BaseReportConfigUserDto> dataList = BaseReportConfigUserConverter.INSTANCE.queryListRes(list);
    ((BaseReportConfigUserService) AopContext.currentProxy()).setName(dataList);
    return new BaseReportConfigUserQueryListRes().setDataList(dataList);
  }


  public @Override DynamicsPage<BaseReportConfigUserExportQueryPageListInfoRes> queryPageList(BaseReportConfigUserExportQueryPageListReq req) {

    DynamicsPage<BaseReportConfigUser> page = new DynamicsPage<>();
    page.setCurrent(req.getPageNum()).setSize(req.getPageSize());
    setQueryListHeader(page);
    MPJLambdaWrapper<BaseReportConfigUser> q = getWrapper(req.getData());
    List<BaseReportConfigUserExportQueryPageListInfoRes> records;
    if (Boolean.TRUE.equals(req.getQueryPage())) {
      IPage<BaseReportConfigUser> list = this.page(page, q);
      IPage<BaseReportConfigUserExportQueryPageListInfoRes> dataList = list.convert(t -> $.copy(t, BaseReportConfigUserExportQueryPageListInfoRes.class));
      records = dataList.getRecords();
    } else {
      records = BaseReportConfigUserConverter.INSTANCE.queryPageListRes(this.list(q));
    }

    // 类型转换，  更换枚举 等操作 

    ((BaseReportConfigUserService) AopContext.currentProxy()).setName(records);
    return DynamicsPage.init(page, records);
  }

  // 以下为私有对象封装

  public @Override void setName(List<? extends BaseReportConfigUserDto> list) {

    //   setNameService.setName(list, SetNamePojoUtils.FACTORY, SetNamePojoUtils.OP_USER_NAME);

  }


  @SuppressWarnings("unchecked")
  private MPJLambdaWrapper<BaseReportConfigUser> getWrapper(BaseReportConfigUserDto obj) {
    MPJLambdaWrapper<BaseReportConfigUser> q = new MPJLambdaWrapper<>();


    LambdaQueryUtil.lambdaQueryWrapper(q, obj, BaseReportConfigUser.class
        // 查询条件
        , BaseReportConfigUser::getReportConfigId //
        , BaseReportConfigUser::getSortIndex //
        , BaseReportConfigUser::getColSpan //
        , BaseReportConfigUser::getHeight //
        , BaseReportConfigUser::getReportName //
        , BaseReportConfigUser::getReportUrl //
        , BaseEntity::getCreateBy
    );


    q.orderByAsc(BaseReportConfigUser::getSortIndex);
    return q;

  }

  private void setQueryListHeader(DynamicsPage<BaseReportConfigUser> page) {

    tableHeaderService.listByBizKey(page, "BaseReportConfigUserService#queryPageList");

  }


}

