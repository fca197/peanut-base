package com.olivia.peanut.base.api.entity.sendMessage;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendMessageReq {

  private String token;
  private String message;
}
