package com.wen.junit;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.inject.Inject;

/**
 * @author huwenwen
 * @since 16/7/12
 */
public class RedisTest extends BaseTest {

  @Inject
  private RedisTemplate redisTemplate;

  @Test
  public void testRedis() {
    ValueOperations<String, String> vop = redisTemplate.opsForValue();
    System.out.println(vop.get("wen1"));
    vop.set("wen1", "good");
  }
}
