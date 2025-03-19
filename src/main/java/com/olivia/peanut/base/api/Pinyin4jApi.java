package com.olivia.peanut.base.api;


import com.olivia.peanut.base.api.entity.pinyin4j.GetSZMReq;
import com.olivia.peanut.base.api.entity.pinyin4j.GetSZMRes;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pinyin4j")
public interface Pinyin4jApi {

  @PostMapping("/getSZM")
  GetSZMRes getSZM(@RequestBody @Valid GetSZMReq req);
}
