package com.wen.junit.mvc;

import com.wen.utils.ReflectUtil;

/**
 * @author huwenwen
 * @since 16/7/29
 */
public class TestReflect extends HandlerImpl {

  public static Object getValue() throws Exception {
    HandlerImpl a = new HandlerImpl();
    a.init();
    HandlerImpl a2 = new HandlerImpl();
    a2.init();
    return ReflectUtil.getFieldValue(a2, "list");
  }

  @Override
  public void init() {
    super.init();
  }

  public static void main(String[] args) throws Exception {
    System.out.println(getValue());
  }
}
