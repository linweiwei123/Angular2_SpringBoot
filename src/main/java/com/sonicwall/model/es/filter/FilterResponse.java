package com.sonicwall.model.es.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.ArrayList;
import com.sonicwall.model.es.filter.*;
import com.sonicwall.model.*;


@ApiModel(description = "")
public class FilterResponse extends BaseResponse {
  
  private ArrayList<FilterModel> inboundFilters  = new ArrayList<FilterModel>();
  private ArrayList<FilterModel> outboundFilters = new ArrayList<FilterModel>();

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("inboundFilters")
  public ArrayList<FilterModel> getInboundFilters() {
    return inboundFilters;
  }
  public void setInboundFilters(ArrayList<FilterModel> inboundFilters) {
    this.inboundFilters = inboundFilters;
  }

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("outboundFilters")
  public ArrayList<FilterModel> getOutboundFilters() {
    return outboundFilters;
  }
  public void setOutboundFilters(ArrayList<FilterModel> outboundFilters) {
    this.outboundFilters = outboundFilters;
  }


}
