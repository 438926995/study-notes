package com.wen.constants;

/**
 * @author huwenwen
 * @since 16/8/19
 */
public class GlobalConstants extends ConfigurableConstants {

  /**
   * 加载属性文件.
   */
  static {
//    init("src/main/java/baidu.properties");
    init("baidu.properties");
  }

  public static final String BAIDU_AK = getProperty("baidu.ak");
  public static final String BAIDU_SK = getProperty("baidu.sk");

}
