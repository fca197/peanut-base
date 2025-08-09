package com.olivia.peanut.base.api.impl.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.olivia.peanut.base.api.entity.baseReportConfig.BaseReportConfigImportReq;
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
