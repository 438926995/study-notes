package com.wen.junit;

import com.wen.dao.user.IUserDao;
import com.wen.entity.MUsers;
import org.junit.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;
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

  @Inject
  private IUserDao userDao;

  @Test
  public void testFindUser(){

  }


}
