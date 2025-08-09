package com.olivia.peanut.base.api.impl.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.olivia.peanut.base.api.entity.baseReportConfigUser.BaseReportConfigUserImportReq;
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
