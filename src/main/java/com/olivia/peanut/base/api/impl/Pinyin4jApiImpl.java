package com.olivia.peanut.base.api.impl;

import com.olivia.peanut.base.api.Pinyin4jApi;
import com.olivia.peanut.base.api.entity.pinyin4j.GetSZMReq;
import com.olivia.peanut.base.api.entity.pinyin4j.GetSZMRes;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pinyin4jApiImpl implements Pinyin4jApi {

  @Override
  public GetSZMRes getSZM(GetSZMReq req) {
    String str = req.getStr();
    if (StringUtils.isBlank(str)) {
      return new GetSZMRes();
    }
    StringBuilder convert = new StringBuilder();
    for (int j = 0; j < str.length(); j++) {
      char word = str.charAt(j);
      // 提取字符的首字母
      String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
      if (pinyinArray != null) {
        convert.append(pinyinArray[0].charAt(0));
      } else {
        convert.append(word);
      }
    }

    return new GetSZMRes().setSzmLower(convert.toString().toLowerCase())
        .setSzmUpper(convert.toString().toUpperCase());
  }
}
