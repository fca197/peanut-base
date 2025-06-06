package com.olivia.peanut.base.api.entity.baseTableHeader;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * (BaseTableHeader)查询对象入参
 *
 * @author peanut
 * @since 2024-03-25 14:19:10
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class BaseTableHeaderQueryByIdListReq {

  private List<Long> idList;


}

