package com.wen.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtil {

  private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

  public static String get(String url) {
    return get(url, null);
  }

  public static String get(String url, Map<String, String> headerParameters) {
    return doRequest(url, headerParameters, null, HttpGet.METHOD_NAME);
  }

  public static String post(String url) {
    return post(url, null);
  }

  public static String post(String url, Map<String, String> bodyParameters) {
    return post(url, null, bodyParameters);
  }

  public static String post(String url, Map<String, String> headerParameters,
      Map<String, String> bodyParameters) {
    return doRequest(url, headerParameters, bodyParameters, HttpPost.METHOD_NAME);
  }


  public static String doRequest(String url, Map<String, String> headerParameters,
      Map<String, String> bodyParameters, String method) {
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;

    try {
      RequestBuilder requestBuilder = RequestBuilder.create(method).setUri(url);
      if (headerParameters != null && !headerParameters.isEmpty()) {
        for (Entry<String, String> entry : headerParameters.entrySet()) {
          requestBuilder.addHeader(entry.getKey(), entry.getValue());
        }
      }
      // 传入参数
      if (HttpPost.METHOD_NAME.equals(method)) {
        if (bodyParameters != null && !bodyParameters.isEmpty()) {
          List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
          for (Entry<String, String> entry : bodyParameters.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
          }
          requestBuilder.setEntity(new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8));
        }
      }
      httpClient = HttpClientBuilder.create().build();
      HttpUriRequest hur = requestBuilder.build();
      // 执行请求获取response返回数据
      response = httpClient.execute(hur);
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        return EntityUtils.toString(entity);
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      return null;
    } finally {
      try {
        if (httpClient != null) {
          httpClient.close();
        }
      } catch (IOException e) {
        logger.error(e.getMessage());
      }
      try {
        if (response != null) {
          response.close();
        }
      } catch (IOException e) {
        logger.error(e.getMessage());
      }
    }
    return null;
  }
}
