package com.wen.oauth2.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * 基于hibernateDaoSupport的二次封装类
 *
 * @author huwenwen
 * @since 16/8/21
 */
public class HibernateDao extends HibernateDaoSupport {

  /**
   * 获取hibernateTemplate
   *
   * @return
   */
  public HibernateTemplate getTemplate() {
    return this.getHibernateTemplate();
  }

  /**
   * 查询list
   *
   * @param hql
   * @param params
   * @param <T>
   * @return
   */
  public <T> List<T> queryList(String hql, Object... params) {
    return (List<T>) getTemplate().find(hql, params);
  }

}
