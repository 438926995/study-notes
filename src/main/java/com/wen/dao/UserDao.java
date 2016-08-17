package com.wen.dao;

import com.wen.entity.User;
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
public class UserDao {

  @Inject
  private SessionFactory sessionFactory;

  @Transactional
  @SuppressWarnings("unchecked")
  public List<User> getAllUser() {
    String hql = "from User";
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery(hql);
    return query.list();
  }

}
