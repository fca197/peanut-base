package com.olivia.peanut.base.api.impl.listener;


import com.olivia.peanut.base.model.BaseReportConfigUser;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.olivia.peanut.base.api.entity.baseReportConfigUser.*;
import com.alibaba.excel.context.AnalysisContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import com.olivia.sdk.listener.AbstractImportListener;

import com.olivia.sdk.utils.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 报表配置用户配置(BaseReportConfigUser)文件导入监听
 *
 * @author makejava
 * @since 2025-03-29 15:59:28
 */
@Slf4j
public class BaseReportConfigUserImportListener extends AbstractImportListener<BaseReportConfigUserImportReq> {

  @Override
  public void invoke(BaseReportConfigUserImportReq data, AnalysisContext analysisContext) {
    //  文件校验
    log.info("BaseReportConfigUserImportListener invoke data:{}", JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
