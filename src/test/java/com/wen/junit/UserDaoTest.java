package com.wen.junit;

import com.wen.dao.UserDao;
import com.wen.dao.user.IUserDao;
import com.wen.entity.MUsers;
import com.wen.entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

/**
 * @author huwenwen
 * @since 16/7/23
 */
public class UserDaoTest extends BaseTest{

  private final static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

//  @Inject
//  private IUserDao userDaoImpl;

  @Inject
  private UserDao userDao;

  @Test
  public void getUser(){
    List<User> allUser = userDao.getAllUser();
    logger.info("allUser is null ,{}" ,allUser == null);
  }


}
