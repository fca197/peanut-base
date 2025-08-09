package com.olivia.peanut.base.api.entity.h3;

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
public class GridDiskDistancesRes {

  private List<List<Long>> dataList;
}
