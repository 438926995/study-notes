package com.wen.junit.mongo;

import com.wen.junit.BaseTest;
import com.wen.service.mongo.MongoService;
import org.junit.Test;

import javax.inject.Inject;

/**
 * @author huwenwen
 * @since 16/11/27
 */
public class MongoServiceTest extends BaseTest {

  @Inject
  private MongoService mongoService;

  @Test
  public void test(){
    mongoService.test();
  }

}
