package com.wen.rabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * rabbitmq 消费者
 *
 * @author huwenwen
 * @since 16/8/26
 */
public class ReceiveMessageListener implements MessageListener {

  private static final Logger logger = LoggerFactory.getLogger(ReceiveMessageListener.class);

  @Override
  public void onMessage(Message message) {
    logger.info("消费者开始消费队列........");
    String messBody = new String(message.getBody());
    logger.info("receive message: {}", messBody);
  }
}
