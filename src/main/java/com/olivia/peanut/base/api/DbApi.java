package com.olivia.peanut.base.api;

import com.olivia.peanut.base.api.entity.db.DbResetReq;
import com.olivia.peanut.base.api.entity.db.DbResetRes;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface DbApi {
  @PostMapping("/db/reset")
  DbResetRes dbReset(@RequestBody @Valid DbResetReq req);
}
