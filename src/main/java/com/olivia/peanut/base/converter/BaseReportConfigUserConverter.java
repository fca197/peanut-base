package com.olivia.peanut.base.converter;

import com.olivia.peanut.base.api.entity.baseReportConfigUser.*;
import com.olivia.peanut.base.model.BaseReportConfigUser;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseReportConfigUserConverter {
  BaseReportConfigUserConverter INSTANCE = Mappers.getMapper(BaseReportConfigUserConverter.class);

  BaseReportConfigUser insertReq(BaseReportConfigUserInsertReq req);

  BaseReportConfigUser updateReq(BaseReportConfigUserUpdateByIdReq req);

  List<BaseReportConfigUserDto> queryListRes(List<BaseReportConfigUser> list);

  List<BaseReportConfigUserExportQueryPageListInfoRes> queryPageListRes(List<BaseReportConfigUser> list);

  List<BaseReportConfigUser> importReq(List<BaseReportConfigUserImportReq> reqList);
}

