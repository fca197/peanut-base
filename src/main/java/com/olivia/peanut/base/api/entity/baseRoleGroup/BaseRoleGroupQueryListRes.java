package com.olivia.peanut.base.api.entity.baseRoleGroup;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 角色组表(BaseRoleGroup)查询对象返回
 *
 * @author peanut
 * @since 2024-07-31 14:33:36
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseRoleGroupQueryListRes {

  /***
   * 返回对象列表
   */
  private List<BaseRoleGroupDto> dataList;


}

