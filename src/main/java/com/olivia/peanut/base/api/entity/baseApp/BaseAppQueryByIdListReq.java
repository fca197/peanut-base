package com.olivia.peanut.base.api.entity.baseApp;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 应用表(BaseApp)查询对象入参
 *
 * @author peanut
 * @since 2024-08-05 11:18:58
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseAppQueryByIdListReq {

  private List<Long> idList;


}

