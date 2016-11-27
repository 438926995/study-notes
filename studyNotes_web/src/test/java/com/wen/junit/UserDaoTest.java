package com.wen.junit;

import com.wen.dao.bigTable.BigTableDao;
import com.wen.dao.user.IUserDao;
import com.wen.entity.BigTable;
import com.wen.entity.MUsers;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author huwenwen
 * @since 16/7/23
 */
public class UserDaoTest extends BaseTest {

  private final static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

  @Inject
  private IUserDao userDao;

  @Inject
  private Md5PasswordEncoder passwordEncoder;

  @Inject
  private BigTableDao bigTableDao;

  @Test
  public void testFindUser() throws InterruptedException {
    int size = 1000000;
    for (int i = 1000; i < size; i++) {
      BigTable bt = new BigTable();
      if (i % 7 != 0) {
        bt.setDate(new Date());
      }
      bt.setName("name" + i);
      bt.setValue(new BigDecimal(i));
      bigTableDao.insert(bt);
    }
  }


}
