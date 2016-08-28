package com.wen.test;

import com.alibaba.fastjson.JSONObject;
import com.wen.bean.OAuthJsonObj;
import com.wen.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huwenwen
 * @since 16/8/28
 */
public class TestRequestOauth2 {

  private static final Logger logger = LoggerFactory.getLogger(TestRequestOauth2.class);

  public static void main(String[] args) {
    // 获取token
    String tokenUrl = "http://localhost:8080/studyNotes_web" + "/oauth/token";
    Map<String, String> tokenParameters = new HashMap<>();
    tokenParameters.put("grant_type", "password");
    tokenParameters.put("client_id", "restapp");
    tokenParameters.put("client_secret", "secret");
    tokenParameters.put("username", "guest");
    tokenParameters.put("password", "guest@123456");
    tokenParameters.put("scope", "read");
    String accessTokenObj = HttpClientUtil.post(tokenUrl, tokenParameters);
    logger.info("accessTokenObj: {}", accessTokenObj);
    JSONObject obj = JSONObject.parseObject(accessTokenObj);
    OAuthJsonObj bean = (OAuthJsonObj) JSONObject.toJavaObject(obj, OAuthJsonObj.class);

    // 请求controller中的对外oauth2Api
    String url = "http://localhost:8080/studyNotes_web" + "/oauth2/api/test";
    Map<String, String> parameters = new HashMap<>();
    if (bean != null) {
      parameters.put("access_token", bean.getAccess_token());
    }
    String result = HttpClientUtil.post(url, parameters);
    logger.info("result: {}", result);
  }

}
