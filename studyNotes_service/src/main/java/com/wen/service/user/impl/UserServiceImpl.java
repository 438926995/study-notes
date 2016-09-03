package com.wen.service.user.impl;

import com.wen.dao.user.IUserDao;
import com.wen.entity.MUsers;
import com.wen.service.user.IUserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author huwenwen
 * @since 16/8/18
 */
@Service
public class UserServiceImpl implements IUserService {

  @Inject
  private IUserDao userDaoImpl;

  @Override
  public List<MUsers> getAllUserInfo() {
    return userDaoImpl.getAllUser();
  }

  @Override
  public MUsers getMusersByUserName(String userName) {
    return userDaoImpl.selectUserByUserName(userName);
  }
}
