package com.wen.junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author huwenwen
 * @since 16/9/4
 */
public class DubboTest {

  private static final Logger logger = LoggerFactory.getLogger(DubboTest.class);

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext(new String[] {"applicationContext-dubbo.xml"});
    context.start();
    logger.info("dubbo提供者服务已注册");
    try {
      // 让此程序一直跑，表示一直提供服务
      System.in.read();
    } catch (IOException e) {
      logger.info(e.getMessage());
    } finally {
      context.close();
    }
  }

}
