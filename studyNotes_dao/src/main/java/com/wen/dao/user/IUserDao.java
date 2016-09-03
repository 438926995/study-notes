package com.wen.dao.user;

import com.wen.entity.MUsers;

import java.util.List;

/**
 * @author huwenwen
 * @since 16/8/17
 */
public interface IUserDao {

  List<MUsers> getAllUser();

  /**
   * 查询用户总量
   *
   * @return
   */
  int selectUserCount();

  /**
   * 根据用户id查询用户信息
   *
   * @param userId
   * @return
   */
  MUsers selectUserByUserId(Long userId);

  /**
   * 根据用户名获取用户信息
   *
   * @param userName
   * @return
   */
  MUsers selectUserByUserName(String userName);

  /**
   * 新增用户
   *
   * @param mu
   * @return
   */
  void insertMUsers(MUsers mu);

  /**
   * 更新用户
   *
   * @param mu
   * @return
   */
  int updateMUsers(MUsers mu);

  /**
   * 根据用户id删除用户
   *
   * @param userId
   * @return
   */
  int delMUsersByUserId(Long userId);

  /**
   * 根据用户名查询密码
   *
   * @param userName
   * @return
   */
  String selectPwdByUserName(String userName);

}
