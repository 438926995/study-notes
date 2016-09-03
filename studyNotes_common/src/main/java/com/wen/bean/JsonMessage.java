package com.wen.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Json 消息封装
 *
 * @author huwenwen
 * @since 16/8/28
 */
@Data
public class JsonMessage implements Serializable {

  private static final long serialVersionUID = 6626170463559839117L;

  private Boolean isSuccess;
  private String message;
  private transient Object data;
  private String errorCode;
}
