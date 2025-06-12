package com.olivia.peanut.base.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.olivia.peanut.base.api.entity.baseResource.BaseResourceDto;
import com.olivia.peanut.base.mapper.LoginAccountMapper;
import com.olivia.peanut.base.model.*;
import com.olivia.peanut.base.service.*;
import com.olivia.sdk.filter.LoginUser;
import com.olivia.sdk.filter.LoginUserContext;
import com.olivia.sdk.utils.$;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/***
 *
 */

@Slf4j
@Service
public class LoginAccountServiceImpl extends ServiceImpl<LoginAccountMapper, LoginAccount> implements LoginAccountService {


  @Resource
  BaseResourceService baseResourceService;

  @Resource
  BaseUserRoleGroupService baseUserRoleGroupService;

  @Resource
  BaseRoleGroupResourceService baseRoleGroupResourceService;


  @Resource
  BaseUserRoleService baseUserRoleService;

  @Resource
  BaseRoleResourceService baseRoleResourceService;


  @Override
  public List<BaseResourceDto> selectBaseResourceList() {

    LoginUser loginUser = LoginUserContext.getLoginUser();
    Set<Long> userRoleIdSet = baseUserRoleService.list(new LambdaQueryWrapper<BaseUserRole>().select(BaseUserRole::getRoleId).eq(BaseUserRole::getUserId, loginUser.getId()))
        .stream().map(BaseUserRole::getRoleId).collect(Collectors.toSet());
    log.info("loginUser :{} userRoleIdSet:{}", loginUser.getLoginPhone(), userRoleIdSet);
    Set<Long> resourceIdSet = new HashSet<>();

    if (CollUtil.isNotEmpty(userRoleIdSet)) {
      resourceIdSet.addAll(baseRoleResourceService.list(new LambdaQueryWrapper<BaseRoleResource>().in(BaseRoleResource::getRoleId, userRoleIdSet))
          .stream().map(BaseRoleResource::getResourceId).toList());
    }

    List<Long> groupRoleIdList = this.baseUserRoleGroupService.list(new LambdaQueryWrapper<BaseUserRoleGroup>().select(BaseUserRoleGroup::getRoleGroupId)
            .eq(BaseUserRoleGroup::getUserId, loginUser.getId()))
        .stream().map(BaseUserRoleGroup::getRoleGroupId).toList();
    if (CollUtil.isNotEmpty(groupRoleIdList)) {
      resourceIdSet.addAll(
          baseRoleGroupResourceService.list(new LambdaQueryWrapper<BaseRoleGroupResource>()
                  .select(BaseRoleGroupResource::getResourceId)
                  .in(BaseRoleGroupResource::getRoleGroupId, groupRoleIdList))
              .stream().map(BaseRoleGroupResource::getResourceId).toList());
    }

    if (CollUtil.isEmpty(resourceIdSet)) {
      return List.of();
    }
    List<BaseResource> baseResourceList = this.baseResourceService.listByIds(resourceIdSet);

    return $.copyList(baseResourceList, BaseResourceDto.class);
  }
}
