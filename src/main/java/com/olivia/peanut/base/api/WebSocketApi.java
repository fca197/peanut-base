package com.olivia.peanut.base.api;


import com.olivia.peanut.base.api.entity.sendMessage.SendMessageReq;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface WebSocketApi {

  @RequestMapping("/webSocket/sendMessageTopic")
  void sendMessageTopic(@RequestBody SendMessageReq message) ;

  @RequestMapping("/webSocket/sendMessageUserToken")
  void sendMessageUserToken(@RequestBody SendMessageReq message) ;
}
