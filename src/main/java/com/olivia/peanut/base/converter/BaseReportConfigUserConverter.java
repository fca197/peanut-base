package com.olivia.peanut.base.converter;

import com.olivia.peanut.base.api.entity.baseReportConfigUser.*;
import com.olivia.peanut.base.model.BaseReportConfigUser;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseReportConfigUserConverter {

  BaseReportConfigUserConverter INSTANCE = Mappers.getMapper(BaseReportConfigUserConverter.class);

  BaseReportConfigUser insertReq(BaseReportConfigUserInsertReq req);

  BaseReportConfigUser updateReq(BaseReportConfigUserUpdateByIdReq req);

  List<BaseReportConfigUser> updateListReq(List<BaseReportConfigUserUpdateByIdReq> req);

  List<BaseReportConfigUserDto> queryListRes(List<BaseReportConfigUser> list);

  List<BaseReportConfigUserExportQueryPageListInfoRes> queryPageListRes(List<BaseReportConfigUser> list);

  List<BaseReportConfigUser> importReq(List<BaseReportConfigUserImportReq> reqList);
}

