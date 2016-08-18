package com.wen.dao.user.impl;

import com.wen.dao.BaseDao;
import com.wen.dao.user.IUserDao;
import com.wen.entity.MUsers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huwenwen
 * @since 16/8/17
 */
@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {

  @Override
  public List<MUsers> getAllUser() {
    String hql = "select mu.userId, mu.userName from MUsers mu";
    return queryList(hql);
  }

  @Override
  public int selectUserCount() {
    String hql = "select count(*) from MUsers";
    return queryCount(hql);
  }

  @Override
  public MUsers selectUserByUserId(Long userId) {
    //TODO hql 不能出现select
    String hql = "from MUsers where userId = ?";
    return querBean(hql, userId);
  }

  @Override
  public void insertMUsers(MUsers mu) {
    save(mu);
  }

  @Override
  public int updateMUsers(MUsers mu) {
    String hql = "update MUsers set userName = ? where userId = ?";
    return update(hql, "wen-update", 1);
  }

  @Override
  public int delMUsersByUserId(Long userId) {
    String hql = "delete MUsers where userId = ?";
    return update(hql, userId);
  }

}
