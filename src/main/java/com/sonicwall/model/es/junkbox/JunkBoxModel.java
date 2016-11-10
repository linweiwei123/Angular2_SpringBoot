package com.sonicwall.model.es.junkbox;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

@ApiModel(description = "")
public class JunkBoxModel  {
  
  public enum ThreatEnum {
     spam,  virus,  phishing,  likely_spam,  likely_virus,  likely_phishing, dha,  policy,  likely_spoof, 
  };
  
  private ThreatEnum threat  = null;
  private Date   receiveTime = null;
  private String from        = null;
  private String to          = null;
  private String subject     = null;
  private String msgId       = null;
  private String mlfId       = null;
  private Boolean attachment = null;

  @JsonProperty("threat")
  public ThreatEnum getThreat() {
    return threat;
  }
  public void setThreat(ThreatEnum threat) {
    this.threat = threat;
  }

  @JsonProperty("receiveTime")
  public Date getReceiveTime() {
    return receiveTime;
  }
  public void setReceiveTime(Date receiveTime) {
    this.receiveTime = receiveTime;
  }

  @JsonProperty("from")
  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }

  @JsonProperty("to")
  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }

  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  @JsonProperty("msgId")
  public String getMsgId() {
    return msgId;
  }
  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }

  @JsonProperty("mlfId")
  public String getMlfId() {
    return mlfId;
  }
  public void setMlfId(String mlfId) {
    this.mlfId = mlfId;
  }

  @JsonProperty("attachment")
  public Boolean getAttachment() {
    return attachment;
  }
  public void setAttachment(Boolean attachment) {
    this.attachment = attachment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JunkBoxModel junkBoxModel = (JunkBoxModel) o;
    return Objects.equals(to      , junkBoxModel.to) && 
        Objects.equals(threat     , junkBoxModel.threat) &&
        Objects.equals(receiveTime, junkBoxModel.receiveTime) &&
        Objects.equals(from       , junkBoxModel.from) &&
        Objects.equals(subject    , junkBoxModel.subject) &&
        Objects.equals(msgId      , junkBoxModel.msgId) &&
        Objects.equals(mlfId      , junkBoxModel.mlfId) &&
        Objects.equals(attachment , junkBoxModel.attachment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(threat, receiveTime, from, to, subject, msgId, mlfId, attachment);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class JunkBoxModel {\n");
    sb.append("  from: ").append(from).append("\n");
    sb.append("  to: ").append(to).append("\n");
    sb.append("  threat: ").append(threat).append("\n");
    sb.append("  receiveTime: ").append(receiveTime).append("\n");
    sb.append("  attachment: ").append(attachment).append("\n");
    sb.append("  subject: ").append(subject).append("\n");
    sb.append("  msgId: ").append(msgId).append("\n");
    sb.append("  mlfId: ").append(mlfId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
