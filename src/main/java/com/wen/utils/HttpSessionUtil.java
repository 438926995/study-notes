package com.wen.utils;

import com.wen.bean.SessionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对象转换成sessionbean工具类.
 *
 * @author huwenwen
 * @since 16/8/19
 */
public class HttpSessionUtil {

  private static final Logger logger = LoggerFactory.getLogger(HttpSessionUtil.class);

  /**
   * userInfo 转变为 sessionBean
   * @param userInfo
   * @return
   */
  public static SessionBean buildUserInfo(Object userInfo){
    if(userInfo instanceof SessionBean){
      return (SessionBean) userInfo;
    } else {
      if(userInfo == null){
        return null;
      }
      return new SessionBean();
    }
  }
}
