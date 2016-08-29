package com.wen.oauth2.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * 实现hibernate
 *
 * @author huwenwen
 * @since 16/7/23
 */
@Transactional
public class BaseDao {

  @Inject
  private SessionFactory sessionFactory;

  /**
   * 获得session
   *
   * @return
   */
  public Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  /**
   * 查询select的结果集
   *
   * @param hql    hql语句
   * @param params ?绑定的参数
   * @param <T>
   * @return
   */
  public <T> List<T> queryList(String hql, Object... params) {
    return createQuery(hql, params).list();
  }

  /**
   * 查询select结果集只有一条的记录
   *
   * @param hql
   * @param params
   * @param <T>
   * @return
   */
  public <T> T querBean(String hql, Object... params) {
    return (T) createQuery(hql, params).uniqueResult();
  }

  /**
   * 查询数量
   *
   * @param hql
   * @param params
   * @return
   */
  public int queryCount(String hql, Object... params) {
    return ((Long) createQuery(hql, params).uniqueResult()).intValue();
  }

  /**
   * 支持update,delete
   * 和 hibernate形式的insert
   *
   * @param hql
   * @param params
   * @return
   */
  public int update(String hql, Object... params) {
    return createQuery(hql, params).executeUpdate();
  }

  /**
   * 保存对象到数据库中,相当于插入
   *
   * @param obj
   */
  public void save(Object obj) {
    getSession().save(obj);
  }

  /**
   * 构建多个参数的查询
   *
   * @param hql    hql语句
   * @param params ?绑定的参数
   * @return
   */
  public Query createQuery(String hql, Object... params) {
    Query query = getSession().createQuery(hql);
    if (params != null) {
      for (int i = 0; i < params.length; i++) {
        Object param = params[i];
        // 类型为long使用setLong
        if (param instanceof java.lang.Long) {
          query.setLong(i, (Long) param);
        } else {
          query.setParameter(i, param);
        }
      }
    }
    return query;
  }

}
