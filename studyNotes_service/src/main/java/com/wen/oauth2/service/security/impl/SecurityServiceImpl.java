package com.wen.oauth2.service.security.impl;

import com.wen.oauth2.dao.user.IUserDao;
import com.wen.oauth2.service.BaseService;
import com.wen.oauth2.service.security.ISecurityService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huwenwen
 * @since 16/8/19
 */
@Service
public class SecurityServiceImpl extends BaseService implements ISecurityService {

  @Inject
  private IUserDao userDaoImpl;

  @Override
  public UserDetails loadUserByUserName(String userName) {
    String userPwd = userDaoImpl.selectPwdByUserName(userName);
    if (userPwd == null) {
      // TODO: 16/8/19  后期加入用户权限
      throw new UsernameNotFoundException("未找到用户名:" + userName);
    }
    List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
    GrantedAuthority ga = new SimpleGrantedAuthority("ROLE_ADMIN");
    grantedAuthorities.add(ga);
    return new User(userName, userPwd, grantedAuthorities);
  }
}
