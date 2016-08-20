package com.wen.security;

import com.wen.bean.SessionBean;
import com.wen.constants.SystemConstans;
import com.wen.entity.MUsers;
import com.wen.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录成功相关处理
 *
 * @author huwenwen
 * @since 16/8/19
 */
public class CustomAuthenticationSuccessHandler
    extends SavedRequestAwareAuthenticationSuccessHandler {

  private static final Logger logger =
      LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

  @Inject
  private IUserService userService;

  /**
   * 登录成功回调
   *
   * @param request
   * @param response
   * @param authentication
   * @throws ServletException
   * @throws IOException
   */
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws ServletException, IOException {
    User user = (User) authentication.getPrincipal();
    MUsers mu = userService.getMusersByUserName(user.getUsername());
    SessionBean sessionBean = new SessionBean(mu.getUserId(), mu.getUserName());
    // session 放入用户信息
    request.getSession().setAttribute(SystemConstans.SESSION_INFO_NAME, sessionBean);

    logger.info("{}用户名密码匹配成功, 验证成功", mu.getUserName());
    super.onAuthenticationSuccess(request, response, authentication);
  }
}
