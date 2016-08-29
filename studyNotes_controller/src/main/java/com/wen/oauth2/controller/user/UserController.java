package com.wen.oauth2.controller.user;

import com.wen.oauth2.entity.MUsers;
import com.wen.oauth2.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

/**
 * @author huwenwen
 * @since 16/8/18
 */
@Controller
public class UserController {

  private final static Logger logger = LoggerFactory.getLogger(UserController.class);

  @Inject
  private IUserService userService;

  @RequestMapping(value = "testFindUser")
  public void testFindUser(){
    List<MUsers> allUserInfo = userService.getAllUserInfo();
    logger.info("size:{}", allUserInfo.size());
  }
}
