package com.olivia.peanut.base.api.entity.baseOplog;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 操作日志(BaseOplog)查询对象返回
 *
 * @author makejava
 * @since 2024-11-30 16:01:02
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseOplogQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<BaseOplogDto> dataList;


}

