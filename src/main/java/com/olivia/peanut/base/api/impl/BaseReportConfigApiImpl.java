package com.olivia.peanut.base.api.impl;

import static com.olivia.peanut.base.converter.BaseReportConfigConverter.INSTANCE;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.olivia.peanut.base.api.BaseReportConfigApi;
import com.olivia.peanut.base.api.entity.baseReportConfig.*;
import com.olivia.peanut.base.api.impl.listener.BaseReportConfigImportListener;
import com.olivia.peanut.base.model.BaseReportConfig;
import com.olivia.peanut.base.service.BaseReportConfigService;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.PoiExcelUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 报表配置(BaseReportConfig)表服务实现类
 *
 * @author makejava
 * @since 2025-03-29 12:32:10
 */
@RestController
public class BaseReportConfigApiImpl implements BaseReportConfigApi {

  private @Autowired BaseReportConfigService baseReportConfigService;

  /****
   * insert
   *
   */
  public @Override BaseReportConfigInsertRes insert(BaseReportConfigInsertReq req) {
    BaseReportConfig baseReportConfig = INSTANCE.insertReq(req);
    this.baseReportConfigService.save(baseReportConfig);
    return new BaseReportConfigInsertRes().setCount(1);
  }

  /****
   * deleteByIds
   *
   */
  public @Override BaseReportConfigDeleteByIdListRes deleteByIdList(BaseReportConfigDeleteByIdListReq req) {
    baseReportConfigService.removeByIds(req.getIdList());
    return new BaseReportConfigDeleteByIdListRes();
  }

  /****
   * queryList
   *
   */
  public @Override BaseReportConfigQueryListRes queryList(BaseReportConfigQueryListReq req) {
    return baseReportConfigService.queryList(req);
  }

  /****
   * updateById
   *
   */
  public @Override BaseReportConfigUpdateByIdRes updateById(BaseReportConfigUpdateByIdReq req) {
    baseReportConfigService.updateById(INSTANCE.updateReq(req));
    return new BaseReportConfigUpdateByIdRes();

  }

  public @Override DynamicsPage<BaseReportConfigExportQueryPageListInfoRes> queryPageList(BaseReportConfigExportQueryPageListReq req) {
    return baseReportConfigService.queryPageList(req);
  }

  public @Override void queryPageListExport(BaseReportConfigExportQueryPageListReq req) {
    DynamicsPage<BaseReportConfigExportQueryPageListInfoRes> page = queryPageList(req);
    List<BaseReportConfigExportQueryPageListInfoRes> list = page.getDataList();
    // 类型转换，  更换枚举 等操作
    PoiExcelUtil.export(BaseReportConfigExportQueryPageListInfoRes.class, list, "报表配置");
  }

  public @Override BaseReportConfigImportRes importData(@RequestParam("file") MultipartFile file) {
    List<BaseReportConfigImportReq> reqList = PoiExcelUtil.readData(file, new BaseReportConfigImportListener(), BaseReportConfigImportReq.class);
    // 类型转换，  更换枚举 等操作
    List<BaseReportConfig> readList = INSTANCE.importReq(reqList);
    boolean bool = baseReportConfigService.saveBatch(readList);
    int c = bool ? readList.size() : 0;
    return new BaseReportConfigImportRes().setCount(c);
  }

  public @Override BaseReportConfigQueryByIdListRes queryByIdListRes(BaseReportConfigQueryByIdListReq req) {
    MPJLambdaWrapper<BaseReportConfig> q = new MPJLambdaWrapper<BaseReportConfig>(BaseReportConfig.class)
        .selectAll(BaseReportConfig.class).in(BaseReportConfig::getId, req.getIdList());
    List<BaseReportConfig> list = this.baseReportConfigService.list(q);
    List<BaseReportConfigDto> dataList = INSTANCE.queryListRes(list);
    this.baseReportConfigService.setName(dataList);
    return new BaseReportConfigQueryByIdListRes().setDataList(dataList);
  }
}
