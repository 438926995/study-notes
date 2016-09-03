package com.wen.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 调用oauth2的oauth/token接口，返回值格式封装
 * 
 * @author huwenwen
 *
 */
@Data
public class OAuthJsonObj implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -6248270679221740629L;

  private String access_token;
  // bearer ??
  private String token_type;

  private String refresh_token;
  // access token 的有效期，单位是秒
  private String expires_in;

  private String scope;
}
