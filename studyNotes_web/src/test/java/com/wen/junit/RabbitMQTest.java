package com.wen.junit;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;

import javax.inject.Inject;

/**
 * @author huwenwen
 * @since 16/8/26
 */
public class RabbitMQTest extends BaseTest {

  @Inject
  private AmqpTemplate amqpTemplate;

  @Test
  public void producerTest() throws InterruptedException {
    amqpTemplate.convertAndSend("producer 1");
    Thread.sleep(1000);
    amqpTemplate.convertAndSend("producer 2");
    Thread.sleep(10000);
  }

}
