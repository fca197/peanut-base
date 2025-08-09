package com.olivia.peanut.base.service;

import com.github.yulichang.base.MPJBaseService;
import com.olivia.peanut.base.api.entity.calendar.*;
import com.olivia.peanut.base.model.Calendar;
import com.olivia.sdk.utils.DynamicsPage;
import com.olivia.sdk.utils.model.WeekInfo;
import java.time.LocalDate;
import java.util.List;

/**
 * 工作日历(Calendar)表服务接口
 *
 * @author makejava
 * @since 2024-03-11 10:44:03
 */
public interface CalendarService extends MPJBaseService<Calendar> {

  CalendarQueryListRes queryList(CalendarQueryListReq req);

  DynamicsPage<CalendarExportQueryPageListInfoRes> queryPageList(CalendarExportQueryPageListReq req);

  List<WeekInfo> getWeekList(Long factoryId, String beginDate, String endDate);

  default List<WeekInfo> getWeekList(Long factoryId, LocalDate beginDate, LocalDate endDate) {
    return getWeekList(factoryId, beginDate.toString(), endDate.toString());
  }
}

