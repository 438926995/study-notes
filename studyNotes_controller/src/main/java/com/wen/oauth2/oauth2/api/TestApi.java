package com.wen.oauth2.oauth2.api;

import com.wen.bean.JsonMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huwenwen
 * @since 16/8/28
 */
@Controller
@RequestMapping(value = "/oauth2/api")
public class TestApi {

  private static final Logger logger = LoggerFactory.getLogger(TestApi.class);

  @RequestMapping(value = "/test", method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public JsonMessage test(){
    logger.info("开始oauth2请求.....");
    JsonMessage json = new JsonMessage();
    json.setSuccess(true);
    json.setMessage("oauth2请求成功....");
    return json;
  }

}
