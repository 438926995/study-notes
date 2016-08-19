package com.wen.service.user;

import com.wen.entity.MUsers;

import java.util.List;

/**
 * 用户相关的service
 *
 * @author huwenwen
 * @since 16/8/18
 */
public interface IUserService {

  List<MUsers> getAllUserInfo();

  /**
   * 根据用户名获得用户信息
   *
   * @param userName
   * @return
   */
  MUsers getMusersByUserName(String userName);

}
