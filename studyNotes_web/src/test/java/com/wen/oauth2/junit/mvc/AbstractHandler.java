package com.wen.oauth2.junit.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huwenwen
 * @since 16/7/29
 */
public abstract class AbstractHandler {

  private static final List<String> list = new ArrayList<String>();

  public void init(){
    list.add("hello");
    list.add("world");
    list.add("wen");
    list.add("hu");
  }
}
