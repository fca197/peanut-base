package com.olivia.peanut.base.api.entity.baseApp;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 应用表(BaseApp)查询对象返回
 *
 * @author peanut
 * @since 2024-08-05 11:18:58
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseAppQueryByIdListRes {

  /***
   * 返回对象列表
   */
  private List<BaseAppDto> dataList;


}

