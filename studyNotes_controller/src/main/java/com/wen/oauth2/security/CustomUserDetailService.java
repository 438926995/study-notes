package com.wen.oauth2.security;

import com.wen.oauth2.service.security.ISecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;

/**
 * 用户登录验证业务逻辑实现类
 *
 * @author huwenwen
 * @since 16/8/19
 */
public class CustomUserDetailService implements UserDetailsService {

  private final static Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

  @Inject
  private ISecurityService securityService;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    logger.info("loadUserByUserName:{}", userName);
    return securityService.loadUserByUserName(userName);
  }
}
