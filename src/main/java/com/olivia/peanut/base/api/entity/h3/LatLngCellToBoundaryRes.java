package com.olivia.peanut.base.api.entity.h3;

import com.uber.h3core.util.LatLng;
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
public class LatLngCellToBoundaryRes {

  private List<LatLng> dataList;
  private Long currentH3code;

}
