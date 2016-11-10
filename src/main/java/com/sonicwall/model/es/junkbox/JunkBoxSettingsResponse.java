package com.sonicwall.model.es.junkbox;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.ArrayList;
import com.sonicwall.model.es.junkbox.*;
import com.sonicwall.model.BaseResponse;

@ApiModel(description = "")
public class JunkBoxSettingsResponse extends BaseResponse {

  public static enum UnjunkActionEnum {
     add_to_allowed_list,  dont_add_to_allowed_list,  ask_user 
  };
  public static class TagSettings {
    private String message ;
    private Boolean enabled;
    public TagSettings(boolean enabled, String message) {
      this.message = message;
      this.enabled = enabled;
    }
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("message")
    public String getMessage() {
      return message;
    }
    public void setMessage(String message) {
      this.message = message;
    }

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }
    public void setEnabled(Boolean enabled) {
      this.enabled = enabled;
    }
  }

  private Integer retentionInDays = 0;
  private UnjunkActionEnum unjunkAction;
  private TagSettings junkTag          ;
  private TagSettings junkInAllowedList;
  private TagSettings junkInPloicyList ;
  private TagSettings processedItem    ;

  public JunkBoxSettingsResponse(Integer retentionInDays, UnjunkActionEnum unjunkAction, TagSettings junkTag, TagSettings junkInAllowedList, TagSettings junkInPloicyList, TagSettings processedItem ) {
    this.retentionInDays = retentionInDays;
    this.unjunkAction = unjunkAction;
    this.junkTag=junkTag;
    this.junkInAllowedList=junkInAllowedList;
    this.junkInPloicyList=junkInPloicyList;
    this.processedItem=processedItem;
  }

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("retentionInDays")
  public Integer getRetentionInDays() {
    return retentionInDays;
  }
  public void setRetentionInDays(Integer retentionInDays) {
    this.retentionInDays = retentionInDays;
  }


  @ApiModelProperty(required = true, value = "")
  @JsonProperty("unjunkAction")
  public UnjunkActionEnum getUnjunkAction() {
    return unjunkAction;
  }
  public void setUnjunkAction(UnjunkActionEnum unjunkAction) {
    this.unjunkAction = unjunkAction;
  }

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("junkTag")
  public TagSettings getJunkTag() {
    return junkTag;
  }
  public void setJunkTag(TagSettings junkTag) {
    this.junkTag = junkTag;
  }


  @ApiModelProperty(required = true, value = "")
  @JsonProperty("junkInAllowedList")
  public TagSettings getJunkInAllowedList() {
    return junkInAllowedList;
  }
  public void setJunkInAllowedList(TagSettings junkInAllowedList) {
    this.junkInAllowedList = junkInAllowedList;
  }

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("junkInPloicyList")
  public TagSettings getJunkInPloicyList() {
    return junkInPloicyList;
  }
  public void setJunkInPloicyList(TagSettings junkInPloicyList) {
    this.junkInPloicyList = junkInPloicyList;
  }

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("processedItem")
  public TagSettings getProcessedItem() {
    return processedItem;
  }
  public void setProcessedItem(TagSettings processedItem) {
    this.processedItem = processedItem;
  }

}
