package com.wen.oauth2.junit;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author huwenwen
 * @since 16/7/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    locations = {"classpath:applicationContext.xml", "classpath:applicationContext-security.xml",
        "classpath:rabbitmq-consumer.xml", "classpath:rabbitmq-producer.xml",
        "classpath:applicationContext-quartz.xml"})
public abstract class BaseTest {

}
