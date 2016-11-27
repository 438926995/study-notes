package com.wen.junit;

import com.alibaba.fastjson.JSON;
import com.wen.entity.MUsers;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    MUsers mu = new MUsers();
    mu.setUserId(1l);
    mu.setUserName("huwenwen");
    mu.setUserPwd("test1234565678967526e516");
    long t1 = System.currentTimeMillis();
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 500000; i++) {
      list.add("test-ap-pricejsafkdjsjfakdj" + i);
      vop.set("test-ap-pricejsafkdjsjfakdj" + i, JSON.toJSONString(mu), 1, TimeUnit.MINUTES);
    }
    //    redisTemplate.delete(list);
    long t2 = System.currentTimeMillis();
    System.out.println("--------------耗时" + (t2 - t1));
  }
}
