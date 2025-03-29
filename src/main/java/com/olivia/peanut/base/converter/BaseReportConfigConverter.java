package com.olivia.peanut.base.converter;

import com.olivia.peanut.base.api.entity.baseReportConfig.*;
import com.olivia.peanut.base.model.BaseReportConfig;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseReportConfigConverter {
  BaseReportConfigConverter INSTANCE = Mappers.getMapper(BaseReportConfigConverter.class);

  BaseReportConfig insertReq(BaseReportConfigInsertReq req);

  BaseReportConfig updateReq(BaseReportConfigUpdateByIdReq req);

  List<BaseReportConfigDto> queryListRes(List<BaseReportConfig> list);

  List<BaseReportConfigExportQueryPageListInfoRes> queryPageListRes(List<BaseReportConfig> list);

  List<BaseReportConfig> importReq(List<BaseReportConfigImportReq> reqList);
}

