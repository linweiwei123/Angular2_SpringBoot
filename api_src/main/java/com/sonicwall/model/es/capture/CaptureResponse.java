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
public class CaptureResponse extends BaseResponse {
  
  private Integer total   = 0;
  private ArrayList<CaptureModel> data = new ArrayList<CaptureModel>();

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
  public ArrayList<CaptureModel> getData() {
    return data;
  }
  public void setData(ArrayList<CaptureModel> dataList) {
    this.data = dataList;
  }

}
