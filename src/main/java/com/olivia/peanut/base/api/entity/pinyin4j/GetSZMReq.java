package com.olivia.peanut.base.api.entity.pinyin4j;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class GetSZMReq {
  private String str;
}
