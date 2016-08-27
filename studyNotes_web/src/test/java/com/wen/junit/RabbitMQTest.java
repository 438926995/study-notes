package com.wen.junit;

import com.wen.entity.MUsers;
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
    MUsers mu = new MUsers();
    mu.setUserId(1l);
    mu.setUserName("rabbitmq-1");
    mu.setUserPwd("rabbitmq-password");
    Thread.sleep(1000);
    amqpTemplate.convertAndSend(mu);
    Thread.sleep(10000);
  }

}
