package com.olivia.peanut.base.api.impl.listener;


import com.olivia.peanut.base.model.BaseReportConfig;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.olivia.peanut.base.api.entity.baseReportConfig.*;
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
 * 报表配置(BaseReportConfig)文件导入监听
 *
 * @author makejava
 * @since 2025-03-29 12:32:12
 */
@Slf4j
public class BaseReportConfigImportListener extends AbstractImportListener<BaseReportConfigImportReq> {

  @Override
  public void invoke(BaseReportConfigImportReq data, AnalysisContext analysisContext) {
    //  文件校验
    log.info("BaseReportConfigImportListener invoke data:{}", JSON.toJSONString(data));
    checkData(data, analysisContext);

  }

}
