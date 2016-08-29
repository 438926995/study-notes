package com.wen.oauth2.junit;

import com.wen.oauth2.dao.TestHibernateDao;
import org.junit.Test;

import javax.inject.Inject;

/**
 * @author huwenwen
 * @since 16/8/21
 */
public class HibernateTest extends BaseTest {

  @Inject
  private TestHibernateDao hibernateDao;

  @Test
  public void testHibernate(){
      hibernateDao.testGetBean();
  }
}
