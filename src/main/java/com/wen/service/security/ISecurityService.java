package com.wen.service.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 权限相关的service
 *
 * @author huwenwen
 * @since 16/8/19
 */
public interface ISecurityService {

  /**
   * 根据用户名,查询并封装spring security 的 User对象
   *
   * @param userName
   * @return
   */
  UserDetails loadUserByUserName(String userName);
}
