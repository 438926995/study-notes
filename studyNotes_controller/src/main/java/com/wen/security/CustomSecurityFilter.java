package com.wen.security;

import com.wen.bean.SessionBean;
import com.wen.constants.GlobalConstants;
import com.wen.constants.SystemConstans;
import com.wen.service.security.ISecurityService;
import com.wen.utils.HttpSessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huwenwen
 * @since 16/8/19
 */
public class CustomSecurityFilter extends AbstractSecurityInterceptor implements Filter {

  private static final Logger logger = LoggerFactory.getLogger(CustomSecurityFilter.class);

  /**
   * 定制安全元数据来源对象(CustomSecurityMetadataSource)
   */
  private FilterInvocationSecurityMetadataSource securityMetadataSource;

  /**
   * 用户权限业务逻辑
   */
  private ISecurityService securityService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    FilterInvocation fi = new FilterInvocation(request, response, chain);
    invoke(fi);
  }

  private void invoke(FilterInvocation fi) throws IOException, ServletException {
    String requestUrl = fi.getRequestUrl();
    HttpServletRequest request = fi.getRequest();
    if (requestUrl.equals("/account/login")) {
      logger.info("判断是登录页面放行");
      fi.getChain().doFilter(request, fi.getResponse());
      return;
    }
    Object userInfo = request.getSession().getAttribute(SystemConstans.SESSION_INFO_NAME);

    // TODO 暂时用户信息用没有存在 auth
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    // 判断用户是否是非法请求
    SessionBean sb = HttpSessionUtil.buildUserInfo(userInfo);
    if (sb != null && sb.getUserName() == null) {
      logger.info("用户session中数据为空");
      sb = null;
    }

    // TODO 如果是管理的不走接下来的一些操作(暂时没有权限拦截的操作)
    if (sb != null) {
      fi.getChain().doFilter(request, fi.getResponse());
      return;
    }

    // 没登录用户请求
    logger.info("sessionBean is null");
    request.getSession().invalidate();
    HttpServletResponse response = fi.getResponse();
    response.sendRedirect(GlobalConstants.PROJECT_URL + "/account/login");
  }

  @Override
  public void destroy() {

  }

  @Override
  public Class<?> getSecureObjectClass() {
    return FilterInvocation.class;
  }

  /**
   * 获取资源元数据源
   *
   * @return
   */
  @Override
  public SecurityMetadataSource obtainSecurityMetadataSource() {
    return this.securityMetadataSource;
  }

  public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
    return securityMetadataSource;
  }

  public void setSecurityMetadataSource(
      FilterInvocationSecurityMetadataSource securityMetadataSource) {
    this.securityMetadataSource = securityMetadataSource;
  }

  public ISecurityService getSecurityService() {
    return securityService;
  }

  public void setSecurityService(ISecurityService securityService) {
    this.securityService = securityService;
  }
}
