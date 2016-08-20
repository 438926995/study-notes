package com.wen.junit;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author huwenwen
 * @since 16/7/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:src/main/resources/applicationContext.xml",
    "classpath:src/main/resources/applicationContext-security.xml"})
public abstract class BaseTest {
}
