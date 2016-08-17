package com.wen.dao.user.impl;

import com.wen.dao.user.IUserDao;
import com.wen.entity.MUsers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * @author huwenwen
 * @since 16/8/17
 */
@Repository
public class UserDaoImpl implements IUserDao {

  @Inject
  private SessionFactory sessionFactory;

  @Override
//  @Transactional
  @SuppressWarnings("unchecked")
  public List<MUsers> getAllUser() {
    String hql = "select mu.userId, mu.userName from MUsers mu";
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery(hql);
    return query.list();
  }
}
