package com.sonicwall.model.es.junkbox;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.ArrayList;
import com.sonicwall.model.es.junkbox.*;
import com.sonicwall.model.*;


@ApiModel(description = "")
public class JunkBoxResponse extends BaseResponse {
  
  private Integer total   = 0;
  private ArrayList<JunkBoxModel> data = new ArrayList<JunkBoxModel>();

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("total")
  public Integer getTotal() {
    return total;
  }
  public void setTotal(Integer total) {
    this.total = total;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("data")
  public ArrayList<JunkBoxModel> getData() {
    return data;
  }
  public void setData(ArrayList<JunkBoxModel> dataList) {
    this.data = dataList;
  }

}
