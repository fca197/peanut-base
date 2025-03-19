package com.olivia.peanut.base.api.entity.account;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class DeleteByIdListReq {
  @Size(min = 1, message = "至少删除一条")
  private List<Long> idList;
}
