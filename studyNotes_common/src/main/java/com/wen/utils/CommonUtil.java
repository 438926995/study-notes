package com.wen.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 通用工具类.
 *
 * @author penglau
 */
public class CommonUtil {

  private CommonUtil() {
  }

  /**
   * 根据Exception对象获取异常详细信息.
   *
   * @param ex Exception对象
   * @return 异常详细信息
   */
  public static String getErrorMessage(Exception ex) {
    StringWriter sw = new StringWriter();
    ex.printStackTrace(new PrintWriter(sw, true));
    return sw.toString();
  }

  /**
   * 根据Throwable对象获取异常详细信息.
   *
   * @param e Throwable对象
   * @return 异常详细信息
   */
  public static String getThrowableMessage(Throwable throwable) {
    StringWriter sw = new StringWriter();
    throwable.printStackTrace(new PrintWriter(sw, true));
    return sw.toString();
  }

  /**
   * 根据Throwable对象获取异常简要信息.
   *
   * @param ex Exception对象.
   * @return 异常简要信息.
   * @deprecated use {@link #getThrowableMessage(Throwable)} instead
   */
  @Deprecated
  public static String getErrorDescription(Exception ex) {
    if (ex.getCause() != null && ex.getCause().getClass() != null) {
      String simpleName = ex.getCause().getClass().getSimpleName();
      String message = ex.getCause().getMessage();
      String error =
          "Error occured caused by exception <strong>%s</strong>:<br/> <strong>%s</strong>";
      return String.format(error, simpleName, message);
    } else {
      return String.format("Error : %s", ex.getMessage());
    }
  }



  /**
   * 判断多个对象或者为空.
   *
   * @param objs 对象数组.
   * @return 有一个为空返回true, 否则返回false.
   * @throws Exception error
   */
  public static Boolean verifyIsNullOfOr(Object... objs) throws Exception {
    if (objs == null || objs.length == 0) {
      return true;
    }
    for (Object obj : objs) {
      if (obj == null) {
        return true;
      }
      if (obj instanceof String && StringUtils.isEmpty(obj.toString())) {
        return true;
      } else if (obj instanceof Collection && ((Collection<?>) obj).isEmpty()) {
        return true;
      } else if (obj instanceof Map && ((Map<?, ?>) obj).size() == 0) {
        return true;
      }
    }
    return false;
  }

  public static boolean isEquals(final Object o1, final Object o2) {
    if (o1 == o2) {
      return true;
    }
    if (o1 == null || o2 == null) {
      return false;
    }
    return o1.equals(o2);
  }

  /**
   * 生成随机的贷款申请单号
   *
   * @return 格式：YYYMMDD+随机数四位
   */
  public static String getRandomDocno() {
    StringBuilder buf = new StringBuilder();
    // 获取当前日期并格式化
    Calendar ca = Calendar.getInstance();
    SimpleDateFormat formt = new SimpleDateFormat("yyyyMMdd");
    // 追加到缓存字符串的后面
    buf.append(formt.format(ca.getTime()));
    // 获得随机数
    Random ran = new Random();
    buf.append(ran.nextInt(10000));
    // 返回缓存内容
    return buf.toString();
  }

  /**
   * 将collction 转换成对应的List<T>
   *
   * @param clazz 想转变的类型class
   * @param c
   * @param <T>
   * @return
   */
  public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
    List<T> resultList = new ArrayList<T>(c.size());
    for (Object o : c)
      resultList.add(clazz.cast(o));
    return resultList;
  }

}
