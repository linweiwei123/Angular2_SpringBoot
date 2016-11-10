package com.sonicwall.model.es.capture;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.ArrayList;
import com.sonicwall.model.es.capture.*;
import com.sonicwall.model.*;


@ApiModel(description = "")
public class CaptureStatsResponse extends BaseResponse {
  
  private Integer total   = 0;
  private ArrayList<CaptureStatsModel> data = new ArrayList<CaptureStatsModel>();

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("total")
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("data")
  public ArrayList<CaptureStatsModel> getData() {
    return data;
  }
  public void setData(ArrayList<CaptureStatsModel> data) {
    this.data = data;
  }

}
