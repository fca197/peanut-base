package com.olivia.peanut.base.api.entity.db;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class DbResetRes {
  private int fileSize;
  private String remainingTime;
  private Long expire;
}
