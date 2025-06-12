package com.olivia.peanut.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.olivia.peanut.base.api.entity.baseResource.BaseResourceDto;
import com.olivia.peanut.base.model.LoginAccount;

import java.util.List;

public interface LoginAccountService extends IService<LoginAccount> {

  List<BaseResourceDto> selectBaseResourceList();

}
