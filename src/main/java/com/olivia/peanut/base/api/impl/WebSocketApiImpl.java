package com.olivia.peanut.base.api.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.olivia.peanut.base.api.WebSocketApi;
import com.olivia.peanut.base.api.entity.sendMessage.SendMessageReq;
import com.olivia.sdk.config.web.socket.entity.WebSocketMessage;
import com.olivia.sdk.config.web.socket.handler.WebSocketSendMsgUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketApiImpl implements WebSocketApi {

  @Override
  public void sendMessageTopic(SendMessageReq message) {
    WebSocketMessage socketSendMsg = new WebSocketMessage().setMessageContent("所有人通知内容")
        .setMessageTitle("所有人通知").setRequestId(IdWorker.get32UUID());
    WebSocketSendMsgUtils.sendToTopic("/allMessage", socketSendMsg);
  }

  @Override
  public void sendMessageUserToken(SendMessageReq message) {

    WebSocketMessage socketSendMsg = new WebSocketMessage().setMessageContent("定人通知内容")
        .setMessageTitle("定人通知").setRequestId(IdWorker.get32UUID());
    WebSocketSendMsgUtils.sendToUserByUserToken(message.getToken(), "/userMessage", socketSendMsg);

  }
}
