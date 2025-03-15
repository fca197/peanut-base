package com.olivia.peanut.base.api.entity.fileUpload;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * (FileUpload)查询对象入参
 *
 * @author peanut
 * @since 2024-03-18 15:22:32
 */
@Accessors(chain = true)
@Getter
@Setter
@SuppressWarnings("serial")
public class FileUploadQueryByIdListReq {

  private List<Long> idList;


}

