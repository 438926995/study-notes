package com.wen.oauth2.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;

/**
 * @author huwenwen
 * @since 16/8/19
 */
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

  private static final Logger logger = LoggerFactory.getLogger(CustomSecurityFilter.class);

  @Override
  public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
    return null;
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return true;
  }
}
