package com.sonicwall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import lombok.*;

// @data annotation generates getters and setters
@Data
public class VersionModel  {
  
  private String version = null;
  private Integer major = null;
  private Integer minor = null;
  private Integer patch = null;
}
