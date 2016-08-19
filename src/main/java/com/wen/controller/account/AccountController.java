package com.wen.controller.account;

import com.wen.bean.SessionBean;
import com.wen.constants.SystemConstans;
import com.wen.utils.HttpSessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huwenwen
 * @since 16/8/19
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

  /**
   * log
   */
  private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

  /**
   * 登录页面
   *
   * @param request
   * @return
   */
  @RequestMapping(value = "/login")
  public ModelAndView login(HttpServletRequest request) {
    logger.info("进入登录页面");
    ModelAndView mav = new ModelAndView("account/login");
    // TODO 登录失败
//    Object loginFail = request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
//    if (loginFail != null) {
//
//    }
    return mav;
  }

  /**
   * 登录成功之后做的事情
   *
   * @param request
   * @return
   */
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public ModelAndView index(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("account/index");
    // TODO 判断session是否失效
//    Object userInfo = request.getSession().getAttribute(SystemConstans.SESSION_INFO_NAME);
//    SessionBean sb = HttpSessionUtil.buildUserInfo(userInfo);
//    if (sb != null && sb.getUserId() != null) {
//      mav.addObject("username", sb.getUserName());
//    } else {
//      logger.error("session 失效了....");
//      // TODO: 16/8/19 跳转到登录页面
//    }
    return mav;
  }

}
