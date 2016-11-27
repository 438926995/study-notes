package com.wen.service.mongo.impl;

import com.alibaba.fastjson.JSON;
import com.wen.entity.BigTable;
import com.wen.service.mongo.MongoService;
import com.wen.service.mongo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author huwenwen
 * @since 16/11/27
 */
@Service
public class MongoServiceImpl implements MongoService {

  private static final Logger logger = LoggerFactory.getLogger(MongoServiceImpl.class);

  @Inject
  private MongoTemplate mongoTemplate;

  @Override
  public void test() {
    User user = new User();
    user.setId("124");
    user.setName("wenwen");
    user.setValue("nihao00");
//    mongoTemplate.createCollection("t_big_table");
    mongoTemplate.save(user, "t_big_table");
    List<User> bigTables =
        mongoTemplate.find(new Query(Criteria.where("name").is("wenwen")), User.class, "t_big_table");
    logger.info("---------{}", JSON.toJSONString(bigTables));
  }
}
