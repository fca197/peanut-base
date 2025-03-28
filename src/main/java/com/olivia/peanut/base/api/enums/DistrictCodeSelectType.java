package com.olivia.peanut.base.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DistrictCodeSelectType {
  provinceCode("provinceName"), cityCode("cityName"), areaCode("areaName"), all("all");
  final String showFieldName;
}
