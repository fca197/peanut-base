package com.olivia.peanut.base.api.impl;

import com.olivia.peanut.base.api.entity.pinyin4j.GetSZMReq;
import com.olivia.peanut.base.api.entity.pinyin4j.GetSZMRes;
import com.olivia.sdk.utils.JSON;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Pinyin4jApiImplTest extends TestCase {

  @Test
  public void test() {
    Pinyin4jApiImpl t = new Pinyin4jApiImpl();
    GetSZMRes szmRes = t.getSZM(new GetSZMReq().setStr("你好哈"));
    log.info("szmRes {}", JSON.toJSONString(szmRes));
  }
}