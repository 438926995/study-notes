package com.wen.util;

import com.wen.constants.GlobalConstants;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Map;

/**
 * 百度sn加密
 *
 * @author huwenwen
 * @since 16/8/29
 */
public class BaiduSnCalUtil {

  /**
   * 得到请求uri
   *
   * @param uri       百度要求的加密uri
   * @param paramsMap 除access_token的参数
   * @return
   * @throws Exception
   */
  public static String getRequestUri(String uri, Map<String, String> paramsMap) throws Exception {
    paramsMap.put("ak", GlobalConstants.BAIDU_AK);
    String paramsStr = toQueryString(paramsMap);
    String wholeStr = new String(uri + paramsStr + GlobalConstants.BAIDU_SK);
    String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
    String sn = MD5(tempStr);
    return uri + paramsStr + "&sn=" + sn;
  }

  // 对Map内所有value作utf8编码，拼接返回结果
  private static String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
    StringBuffer queryString = new StringBuffer();
    for (Map.Entry<?, ?> pair : data.entrySet()) {
      queryString.append(pair.getKey() + "=");
      queryString.append(URLEncoder.encode((String) pair.getValue(), "UTF-8") + "&");
    }
    if (queryString.length() > 0) {
      queryString.deleteCharAt(queryString.length() - 1);
    }
    return queryString.toString();
  }

  // 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
  private static String MD5(String md5) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] array = md.digest(md5.getBytes());
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < array.length; ++i) {
        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
      }
      return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
  }

}
