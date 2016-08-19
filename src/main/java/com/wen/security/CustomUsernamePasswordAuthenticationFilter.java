package com.wen.security;

import com.wen.entity.MUsers;
import com.wen.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户名密码验证过滤器
 *
 * @author huwenwen
 * @since 16/8/19
 */
public class CustomUsernamePasswordAuthenticationFilter
    extends UsernamePasswordAuthenticationFilter {

  private final static Logger logger =
      LoggerFactory.getLogger(CustomUsernamePasswordAuthenticationFilter.class);

  @Inject
  private Md5PasswordEncoder passwordEncoder;

  @Inject
  private IUserService userService;

  private Boolean forwardToDestination;

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {
    if (!request.getMethod().equals(RequestMethod.POST)) {
      throw new AuthenticationServiceException("非POST提交,拒绝登录请求");
    }
    return loginHandle(request);
  }

  /**
   * 验证密码是否正确
   *
   * @param request
   * @return
   */
  private Authentication loginHandle(HttpServletRequest request) {
    String userName = obtainUsername(request);
    String userPwd = obtainPassword(request);
    logger.info("用户{}请求登录...", userName);

    MUsers mu = userService.getMusersByUserName(userName);
    if (mu == null) {
      logger.error("用户{}信息查询为空", userName);
      loginFailHandle(request, userName, "用户不存在");
    } else if (!mu.getUserPwd().equals(passwordEncoder.encodePassword(userPwd, userName))) {
      logger.error("用户{}输入密码有误", userName);
      loginFailHandle(request, userName, "密码错误");
    }
    // UsernamePasswordAuthenticationToken实现 Authentication
    UsernamePasswordAuthenticationToken authRequest =
        new UsernamePasswordAuthenticationToken(userName, userPwd);
    // 允许子类设置详细属性
    setDetails(request, authRequest);
    // 运行UserDetailsService的loadUserByUsername 再次封装Authentication
    return this.getAuthenticationManager().authenticate(authRequest);
  }

  /*
   * 在我们配置的simpleUrlAuthenticationFailureHandler处理登录失败的处理类在这么一段 这样我们可以在登录失败后，向用户提供相应的信息。
   */
  private void loginFailHandle(HttpServletRequest request, String userName, String msg) {
    AuthenticationServiceException exception =
        new AuthenticationServiceException(userName + "##" + msg);
    if (forwardToDestination) {
      request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
    } else {
      HttpSession session = request.getSession(false);

      if (session != null || getAllowSessionCreation()) {
        request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
      }
    }
    throw exception;
  }

  public Boolean getForwardToDestination() {
    return forwardToDestination;
  }

  public void setForwardToDestination(Boolean forwardToDestination) {
    this.forwardToDestination = forwardToDestination;
  }
}
