package com.olivia.peanut.base.api.entity.msgMessage;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * (MsgMessage)查询对象返回
 *
 * @author peanut
 * @since 2024-03-23 19:05:39
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class MsgMessageQueryListRes {

  /***
   * 返回对象列表
   */
  private List<MsgMessageDto> dataList;


}

