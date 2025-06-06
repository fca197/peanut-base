package com.olivia.peanut.base.api.entity.h3;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/***
 *
 */
@Setter
@Getter
@Accessors(chain = true)
public class CellToLatLngRes {

  private double lat;
  private double lng;
}
