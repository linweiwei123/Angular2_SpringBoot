package com.sonicwall.model.es.capture;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

@ApiModel(description = "")
public class CaptureModel  {
  
  public enum StatusEnum {
     action_required,  blocked,  scan_failed,  scan_pending,  scanned,  malicious
  };
  public enum ProtocolEnum {
     HTTP,  HTTPS,  FTP,  UDP, 
  };
  
  private StatusEnum status = null;
  private Date timestamp = null;
  private String filename = null;
  private ProtocolEnum protocol = null;
  private String submitBy = null;
  private String src = null;
  private String dest = null;
  private Boolean isActive = null;

  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @JsonProperty("timestamp")
  public Date getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }

  @JsonProperty("protocol")
  public ProtocolEnum getProtocol() {
    return protocol;
  }
  public void setProtocol(ProtocolEnum protocol) {
    this.protocol = protocol;
  }

  @JsonProperty("submitBy")
  public String getSubmitBy() {
    return submitBy;
  }
  public void setSubmitBy(String submitBy) {
    this.submitBy = submitBy;
  }

  @JsonProperty("src")
  public String getSrc() {
    return src;
  }
  public void setSrc(String src) {
    this.src = src;
  }

  @JsonProperty("dest")
  public String getDest() {
    return dest;
  }
  public void setDest(String dest) {
    this.dest = dest;
  }

  @JsonProperty("isActive")
  public Boolean getIsActive() {
    return isActive;
  }
  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CaptureModel captureModel = (CaptureModel) o;
    return Objects.equals(status, captureModel.status) &&
        Objects.equals(timestamp, captureModel.timestamp) &&
        Objects.equals(filename, captureModel.filename) &&
        Objects.equals(protocol, captureModel.protocol) &&
        Objects.equals(submitBy, captureModel.submitBy) &&
        Objects.equals(src, captureModel.src) &&
        Objects.equals(dest, captureModel.dest) &&
        Objects.equals(isActive, captureModel.isActive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, timestamp, filename, protocol, submitBy, src, dest, isActive);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CaptureModel {\n");
    
    sb.append("  status: ").append(status).append("\n");
    sb.append("  timestamp: ").append(timestamp).append("\n");
    sb.append("  filename: ").append(filename).append("\n");
    sb.append("  protocol: ").append(protocol).append("\n");
    sb.append("  submitBy: ").append(submitBy).append("\n");
    sb.append("  src: ").append(src).append("\n");
    sb.append("  dest: ").append(dest).append("\n");
    sb.append("  isActive: ").append(isActive).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
