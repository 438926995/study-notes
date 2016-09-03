package com.wen.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huwenwen
 * @since 16/8/27
 */
public class TestTask {

  private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

  public void excute(){
      logger.info("定时任务测试.........");
  }

}
