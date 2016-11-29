package com.sonicwall.model.es.scanned;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class ScannedModel  {
  
  public enum StatusEnum {
     action_required,  blocked,  scan_failed,  scan_pending,  scanned,  malicious, 
  };
  
  private StatusEnum status = null;
  private String timestamp = null;
  private String filename = null;
  public enum ProtocolEnum {
     HTTP,  HTTPS,  FTP,  UDP, 
  };
  
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
  public String getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(String timestamp) {
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
    ScannedModel scannedModel = (ScannedModel) o;
    return Objects.equals(status, scannedModel.status) &&
        Objects.equals(timestamp, scannedModel.timestamp) &&
        Objects.equals(filename, scannedModel.filename) &&
        Objects.equals(protocol, scannedModel.protocol) &&
        Objects.equals(submitBy, scannedModel.submitBy) &&
        Objects.equals(src, scannedModel.src) &&
        Objects.equals(dest, scannedModel.dest) &&
        Objects.equals(isActive, scannedModel.isActive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, timestamp, filename, protocol, submitBy, src, dest, isActive);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScannedModel {\n");
    
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
