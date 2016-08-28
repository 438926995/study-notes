package com.wen.bean;

import java.io.Serializable;

/**
 * Json 消息封装
 *
 * @author huwenwen
 * @since 16/8/28
 */
public class JsonMessage implements Serializable {

  private static final long serialVersionUID = 6626170463559839117L;

  private Boolean isSuccess;
  private String message;
  private transient Object data;
  private String errorCode;

  public Boolean getSuccess() {
    return isSuccess;
  }

  public void setSuccess(Boolean success) {
    isSuccess = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}
