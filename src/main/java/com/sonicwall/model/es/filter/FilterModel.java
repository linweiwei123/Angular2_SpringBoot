package com.sonicwall.model.es.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

@ApiModel(description = "")
public class FilterModel  {
  
  public enum FilterActionEnum {
     store_in_junkbox,  
     analyze,  
     delete,  
     store_in_approvalbox,  
     reject_smtp_error_550,
     deliver_and_reject_smtp_error_550,
     route_to,
     deliver_and_route_to,
     route_to_ip,
     deliver_and_route_to_ip,
     encrypt,
     decrypt,
     tag_subject,
     strip_attachments,
     append_text_to_message,
     issue_email_notification,
     add_header,
     remove_header
  };
  
  private int    order;
  private String name        = null;
  private String applyTo     = "everyone";
  private String purpose     = null;
  private Boolean isEnabled  = null;
  private FilterActionEnum filterAction  = null;
  private String filterActionValue       = null;
  private ArrayList<FilterConditionModel> filterConditions = new ArrayList<FilterConditionModel>();


  public FilterModel(int order, String name, String applyTo, FilterActionEnum filterAction, Boolean isEnabled) {
    this.order       = order;
    this.name        = name;
    this.applyTo     = applyTo;
    this.filterAction = filterAction;
    this.isEnabled   = isEnabled;
  }

  @JsonProperty("order")
  public int getOrder() {
    return order;
  }
  public void setorder(int order) {
    this.order = order;
  }

  @ApiModelProperty(value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("applyTo")
  public String getApplyTo() {
    return applyTo;
  }
  public void setApplyTo(String applyTo) {
    this.applyTo = applyTo;
  }

  @JsonProperty("purpose")
  public String getPurpose() {
    return purpose;
  }
  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  @JsonProperty("isEnabled")
  public Boolean getIsEnabled() {
    return isEnabled;
  }
  public void setIsEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  @JsonProperty("filterAction")
  public FilterActionEnum getFilterAction() {
    return filterAction;
  }
  public void setFilterAction(FilterActionEnum filterAction) {
    this.filterAction = filterAction;
  }


  @JsonProperty("filterActionValue")
  public String getFilterActionValue() {
    return filterActionValue;
  }
  public void setFilterActionValue(String filterActionValue) {
    this.filterActionValue = filterActionValue;
  }

  @JsonProperty("filterConditions")
  public ArrayList<FilterConditionModel> getFilterConditions() {
    return filterConditions;
  }
  public void setFilterConditions(ArrayList<FilterConditionModel> filterConditions) {
    this.filterConditions = filterConditions;
  }


}
