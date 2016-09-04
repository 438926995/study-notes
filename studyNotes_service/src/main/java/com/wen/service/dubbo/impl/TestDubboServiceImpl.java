package com.wen.service.dubbo.impl;

import com.wen.client.service.TestSoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author huwenwen
 * @since 16/9/3
 */
public class TestDubboServiceImpl implements TestSoaService {

  private static final Logger logger = LoggerFactory.getLogger(TestDubboServiceImpl.class);

  @Override
  public String getSoa() {
    return "soa dubbo";
  }
}
