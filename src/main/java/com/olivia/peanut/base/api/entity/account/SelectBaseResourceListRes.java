package com.olivia.peanut.base.api.entity.account;

import com.olivia.peanut.base.api.entity.baseResource.BaseResourceDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class SelectBaseResourceListRes {

  private List<BaseResourceDto> dataList;
}
