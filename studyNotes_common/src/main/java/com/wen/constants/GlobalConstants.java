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
    init("src/main/java/variable.properties");
  }

  // 项目路径
  public static final String PROJECT_URL = getProperty("project_url");

}
