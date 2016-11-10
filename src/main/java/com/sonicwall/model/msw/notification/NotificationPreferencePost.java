package com.sonicwall.model.msw.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;

public class NotificationPreferencePost  {
  
  private String notifyTypeId;
  private boolean isEnabled = false;
  private String emailStatus="2"; // Set default value of 2


  @JsonProperty("notifyTypeId")
  public String getNotifyTypeId() {
    return notifyTypeId;
  }
  public void setNotifyTypeId(String notifyTypeId) {
    this.notifyTypeId = notifyTypeId;

  }

  @JsonProperty("isEnabled")
  public boolean getIsEnabled() {
    return isEnabled;
  }
  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  @JsonProperty("emailStatus")
  public String getEmailStatus() {
    return emailStatus;
  }
  public void setEmailStatus(String emailStatus) {
    this.emailStatus = emailStatus;
  }

}
