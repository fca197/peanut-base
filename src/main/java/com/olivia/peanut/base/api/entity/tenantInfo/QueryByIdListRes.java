package com.olivia.peanut.base.api.entity.tenantInfo;

import com.olivia.peanut.base.model.TenantInfo;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/***
 *
 */
@Setter
@Getter
@Accessors(chain = true)
public class QueryByIdListRes {

  private List<TenantInfo> data;
}
