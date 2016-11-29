package com.sonicwall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@ApiModel(description = "")
public class BaseResponse  {
  
  @ApiModelProperty(required = true) 
  @Getter @Setter private Boolean success  = null;
  @Getter @Setter private String  msgKey   = ""; // SUCCESS, ERROR, WARNING, NO_ACCESS
  @Getter @Setter private String  msg      = "";
  @Getter @Setter private String  locale   = "";
}
