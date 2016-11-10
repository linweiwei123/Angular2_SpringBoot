package com.sonicwall.model.es.scanned;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.ArrayList;
import com.sonicwall.model.BaseResponse;
import com.sonicwall.model.es.scanned.ScannedModel;


@ApiModel(description = "")
public class ScannedResponse extends BaseResponse {
  
  private Integer total   = 0;
  private ArrayList<ScannedModel> data = new ArrayList<ScannedModel>();;

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
  public ArrayList<ScannedModel> getData() {
    return data;
  }
  public void setData(ArrayList<ScannedModel> dataList) {
    this.data = dataList;
  }

}
