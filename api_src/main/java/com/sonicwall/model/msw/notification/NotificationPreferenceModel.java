package com.sonicwall.model.msw.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;

@Entity
public class NotificationPreferenceModel  {
  
  private String username;
  private String notifyTypeId;
  private String notifyTypeDescr;
  private boolean isEnabled = false;
  private String emailStatus="2"; // Set default value of 2

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Version
  private long version;

  @ApiModelProperty(value = "")
  @Column(nullable = false)
  @JsonProperty("username")
  public String getUsername() {
      return username;
  }
  public void setUsername(String username) {
      this.username = username;
  }

  @ApiModelProperty(value = "")
  @Column(nullable = false)
  @JsonProperty("notifyTypeId")
  public String getNotifyTypeId() {
    return notifyTypeId;
  }
  public void setNotifyTypeId(String notifyTypeId) {
    String descr="";
    switch (notifyTypeId) {
      case "1":
          descr = "Dell SonicWALL Security Center";
          break;
      case "2":
         descr = "New Software and Firmware Upgrades";
          break;
      case "3":
          descr = "Security Notices";
          break;
      case "4":
          descr = "New Product and Feature Releases";
          break;
      case "5":
          descr = "Site and Infrastructure updates";
          break;
      case "6":
          descr = "Firewall Security";
          break;
      case "7":
          descr = "Dell Security Community";
          break;
      case "8":
          descr = "Dell SonicWALL Threat Protection";
          break;
      default: 
          descr = "Unknown";
          break;
    }
    this.notifyTypeId = notifyTypeId;
    this.notifyTypeDescr =descr;

  }


  @ApiModelProperty(value = "")
  @JsonProperty("notifyTypeDescr")
  public String getNotifyTypeDescr() {
    return notifyTypeDescr;
  }
  // Make this Readonly
  /*
  public void setNotifyTypeDescr(String notifyTypeDescr) {
    this.notifyTypeDescr = notifyTypeDescr;
  }
  */
 
  @ApiModelProperty(value = "")
  @JsonProperty("isEnabled")
  public boolean getIsEnabled() {
    return isEnabled;
  }
  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  @ApiModelProperty(value = "")
  @JsonProperty("emailStatus")
  public String getEmailStatus() {
    return emailStatus;
  }
  public void setEmailStatus(String emailStatus) {
    this.emailStatus = emailStatus;
  }

}
