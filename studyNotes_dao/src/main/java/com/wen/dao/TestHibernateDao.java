package com.wen.dao;

import com.wen.entity.MUsers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huwenwen
 * @since 16/8/21
 */
@Repository
public class TestHibernateDao extends HibernateDao {

  public void testGetBean() {
    String hql = "from MUsers where userId = ?";
    MUsers paramBean = new MUsers();
    paramBean.setUserId(1l);
    List<MUsers> mu = queryList(hql, 1l);
    for (MUsers item : mu) {
      System.out.println(item.getUserName());
    }

    System.out.println(mu.size());
  }


}
