package com.github.huwenwen.crawler;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huwenwen
 * @since 2017/2/23
 */
public class LinkQueue {

  private static Set visitedUrl = new HashSet();

  private static Queue unVisitedUrl = new Queue();

  // 获得url队列
  public static Queue getUnVisitedUrl() {
    return unVisitedUrl;
  }

  // 添加到访问过的队列中
  public static void addVisitedUrl(String url) {
    visitedUrl.add(url);
  }

  // 移除访问过的url
  public static void removeVisitedUrl(String url){
    
  }
}
