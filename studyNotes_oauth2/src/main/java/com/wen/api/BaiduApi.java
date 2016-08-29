package com.wen.api;

import com.alibaba.fastjson.JSONObject;
import com.wen.bean.BaiduIPDefaultResult;
import com.wen.util.BaiduSnCalUtil;
import com.wen.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 百度对外免费api
 *
 * @author huwenwen
 * @since 16/8/29
 */
public class BaiduApi {
  private static final Logger logger = LoggerFactory.getLogger(BaiduApi.class);

  private String baidumapurlhead = "http://api.map.baidu.com";

  /**
   * 根据ip获取地址
   *
   * @param ip
   * @return
   */
  public String getAddressByIp(String ip){
    Map paramsMap = new LinkedHashMap<String, String>();
    paramsMap.put("ip", ip);
    try{
      String uri = BaiduSnCalUtil.getRequestUri("/location/ip?", paramsMap);
      String url = baidumapurlhead + uri;
      String json = HttpClientUtil.get(url);
      JSONObject jsonObject = JSONObject.parseObject(json);
      BaiduIPDefaultResult result =
          JSONObject.toJavaObject(jsonObject, BaiduIPDefaultResult.class);
      String province = result.getContent().getAddress_detail().getProvince();
      String city = result.getContent().getAddress_detail().getCity();
      return province + " " + city;
    } catch (Exception e){
      logger.error(e.getMessage());
    }
    return null;
  }

}
