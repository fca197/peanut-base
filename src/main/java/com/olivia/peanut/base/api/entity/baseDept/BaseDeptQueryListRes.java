package com.olivia.peanut.base.api.entity.baseDept;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 部门表(BaseDept)查询对象返回
 *
 * @author peanut
 * @since 2024-07-31 14:33:30
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseDeptQueryListRes {

  /***
   * 返回对象列表
   */
  private List<BaseDeptDto> dataList;


}

