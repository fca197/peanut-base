package com.olivia.peanut.base.api.entity.baseAppResource;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 资源(BaseAppResource)查询对象入参
 *
 * @author peanut
 * @since 2024-08-06 17:30:28
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseAppResourceExportQueryPageListReq {

  private int pageNum;
  private int pageSize;
  private Boolean queryPage = true;
  private BaseAppResourceDto data;


}

