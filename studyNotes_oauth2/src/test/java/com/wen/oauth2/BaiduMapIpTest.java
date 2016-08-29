package com.wen.oauth2;

import com.wen.api.BaiduApi;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huwenwen
 * @since 16/8/29
 */
public class BaiduMapIpTest {

  private static final Logger logger = LoggerFactory.getLogger(BaiduMapIpTest.class);

  @Test
  public void testGetIpAddress(){
    BaiduApi api = new BaiduApi();
    String addressByIp = api.getAddressByIp("117.27.227.184");
    logger.info(addressByIp);
  }

}
