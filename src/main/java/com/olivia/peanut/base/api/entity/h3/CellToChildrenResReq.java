package com.olivia.peanut.base.api.entity.h3;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


/***
 *
 */
@Setter
@Getter
@Accessors(chain = true)
public class CellToChildrenResReq {

  @NotBlank
  private Long h3Code;
  private int res;
}
