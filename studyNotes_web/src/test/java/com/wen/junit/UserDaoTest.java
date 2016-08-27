package com.wen.junit;

import com.wen.dao.user.IUserDao;
import com.wen.entity.MUsers;
import org.junit.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import javax.inject.Inject;
import java.util.List;

/**
 * @author huwenwen
 * @since 16/7/23
 */
public class UserDaoTest extends BaseTest{

  private final static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

  @Inject
  private IUserDao userDao;

  @Inject
  private Md5PasswordEncoder passwordEncoder;

  @Test
  public void testFindUser() throws InterruptedException {
//    MUsers mUsers = userDao.selectUserByUserId(1l);
//    logger.info(mUsers.getUserName());
    String s = passwordEncoder.encodePassword("admin", "admin");
    logger.info("========{}", s);
//    userDao.selectPwdByUserName("admin");
    MUsers admin = userDao.selectUserByUserName("admin");
    Thread.sleep(10000);
    logger.info(admin.getUserPwd());
  }


}
