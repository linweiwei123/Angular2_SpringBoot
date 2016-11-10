package com.sonicwall.model.es.capture;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

@ApiModel(description = "")
public class CaptureStatsModel  {
  
  private Date date          = null;
  private int blocked;
  private int scanFailed;
  private int scanPending;
  private int malicious;
  private int actionRequired;
  private int total;


  @JsonProperty("date")
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

  @JsonProperty("blocked")
  public int getBlocked() {
    return blocked;
  }
  public void setBlocked(int blocked) {
    this.blocked = blocked;
  }

  @JsonProperty("scanFailed")
  public int getScanFailed() {
    return scanFailed;
  }
  public void setScanFailed(int scanFailed) {
    this.scanFailed = scanFailed;
  }

  @JsonProperty("scanPending")
  public int getScanPending() {
    return scanPending;
  }
  public void setScanPending(int scanPending) {
    this.scanPending = scanPending;
  }

  @JsonProperty("total")
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }

  @JsonProperty("malicious")
  public int getMalicious() {
    return malicious;
  }
  public void setMalicious(int malicious) {
    this.malicious = malicious;
  }

  @JsonProperty("actionRequired")
  public int getActionRequired() {
    return actionRequired;
  }
  public void setActionRequired(int actionRequired) {
    this.actionRequired = actionRequired;
  }

}