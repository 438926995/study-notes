package com.wen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author huwenwen
 * @since 16/8/17
 */
@Entity
@Table(name = "m_users")
public class User {

  private Integer userId;

  private String userName;

  public User() {
  }

  public User(Integer userId, String userName) {
    this.userId = userId;
    this.userName = userName;
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "user_id")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Column(name = "user_name")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
