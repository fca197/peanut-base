package com.olivia.peanut.base.api.impl;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.base.api.BaseReportConfigUserApi;
import com.olivia.peanut.base.api.entity.baseReportConfigUser.*;
import com.olivia.peanut.base.api.impl.listener.BaseReportConfigUserImportListener;
import com.olivia.peanut.base.model.BaseReportConfigUser;
import com.olivia.peanut.base.service.BaseReportConfigUserService;
import com.olivia.sdk.filter.LoginUserContext;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

import static com.olivia.peanut.base.converter.BaseReportConfigUserConverter.INSTANCE;

/**
 * 报表配置用户配置(BaseReportConfigUser)表服务实现类
 *
 * @author makejava
 * @since 2025-03-29 15:59:26
 */
@RestController
public class BaseReportConfigUserApiImpl implements BaseReportConfigUserApi {

  private @Autowired BaseReportConfigUserService baseReportConfigUserService;

  /****
   * insert
   *
   */
  public @Override BaseReportConfigUserInsertRes insert(BaseReportConfigUserInsertReq req) {
    BaseReportConfigUser baseReportConfigUser = INSTANCE.insertReq(req);
    this.baseReportConfigUserService.save(baseReportConfigUser);
    return new BaseReportConfigUserInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override BaseReportConfigUserDeleteByIdListRes deleteByIdList(BaseReportConfigUserDeleteByIdListReq req) {
    baseReportConfigUserService.removeByIds(req.getIdList());
    return new BaseReportConfigUserDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override BaseReportConfigUserQueryListRes queryList(BaseReportConfigUserQueryListReq req) {
    return baseReportConfigUserService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override BaseReportConfigUserUpdateByIdRes updateById(BaseReportConfigUserUpdateByIdReq req) {
    baseReportConfigUserService.updateById(INSTANCE.updateReq(req));
    return new BaseReportConfigUserUpdateByIdRes();

  }

  public @Override DynamicsPage<BaseReportConfigUserExportQueryPageListInfoRes> queryPageList(BaseReportConfigUserExportQueryPageListReq req) {
    return baseReportConfigUserService.queryPageList(req);
  }

  @Override
  public DynamicsPage<BaseReportConfigUserExportQueryPageListInfoRes> queryPageListSelf(BaseReportConfigUserExportQueryPageListReq req) {
    BaseReportConfigUserDto data = req.getData();
    if (Objects.isNull(data)) {
      BaseReportConfigUserDto userDto = new BaseReportConfigUserDto();
      userDto.setCreateBy(LoginUserContext.getLoginUser().getId());
      req.setData(userDto);
    } else {
      data.setCreateBy(LoginUserContext.getLoginUser().getId());
    }
    return baseReportConfigUserService.queryPageList(req);
  }

  public @Override void queryPageListExport(BaseReportConfigUserExportQueryPageListReq req) {
    DynamicsPage<BaseReportConfigUserExportQueryPageListInfoRes> page = queryPageList(req);
    List<BaseReportConfigUserExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(BaseReportConfigUserExportQueryPageListInfoRes.class, list, "报表配置用户配置");
  }

  public @Override BaseReportConfigUserImportRes importData(@RequestParam("file") MultipartFile file) {
    List<BaseReportConfigUserImportReq> reqList = PoiExcelUtil.readData(file, new BaseReportConfigUserImportListener(), BaseReportConfigUserImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<BaseReportConfigUser> readList = INSTANCE.importReq(reqList);
    boolean bool = baseReportConfigUserService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new BaseReportConfigUserImportRes().setCount(c);
  }

  public @Override BaseReportConfigUserQueryByIdListRes queryByIdListRes(BaseReportConfigUserQueryByIdListReq req) {
    MPJLambdaWrapper<BaseReportConfigUser> q = new MPJLambdaWrapper<BaseReportConfigUser>(BaseReportConfigUser.class)
        .selectAll(BaseReportConfigUser.class).in(BaseReportConfigUser::getId, req.getIdList());
    List<BaseReportConfigUser> list = this.baseReportConfigUserService.list(q);
    List<BaseReportConfigUserDto> dataList = INSTANCE.queryListRes(list);
    this.baseReportConfigUserService.setName(dataList);
    return new BaseReportConfigUserQueryByIdListRes().setDataList(dataList);
  }
}
