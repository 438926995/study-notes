package com.wen.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * session信息封装类
 *
 * @author huwenwen
 * @since 16/8/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionBean implements Serializable {

  private static final long serialVersionUID = 2005966533615344343L;

  private Long userId;
  private String userName;

//  public SessionBean(Long userId, String userName) {
//    this.userId = userId;
//    this.userName = userName;
//  }
//
//  public SessionBean() {
//  }
//
//  public Long getUserId() {
//    return userId;
//  }
//
//  public void setUserId(Long userId) {
//    this.userId = userId;
//  }
//
//  public String getUserName() {
//    return userName;
//  }
//
//  public void setUserName(String userName) {
//    this.userName = userName;
//  }
}
