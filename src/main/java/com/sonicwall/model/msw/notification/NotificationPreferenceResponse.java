package com.sonicwall.model.msw.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.ArrayList;
import com.sonicwall.model.msw.notification.*;
import com.sonicwall.model.*;


@ApiModel(description = "")
public class NotificationPreferenceResponse extends BaseResponse {
  
  private Integer total   = 0;
  private ArrayList<NotificationPreferenceModel> data = new ArrayList<NotificationPreferenceModel>();;

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
  public ArrayList<NotificationPreferenceModel> getData() {
    return data;
  }
  public void setData(ArrayList<NotificationPreferenceModel> dataList) {
    this.data = dataList;
  }

}
