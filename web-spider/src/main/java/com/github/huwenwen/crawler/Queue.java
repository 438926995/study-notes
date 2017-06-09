package com.github.huwenwen.crawler;

import java.util.LinkedList;

/**
 * @author huwenwen
 * @since 2017/2/23
 */
public class Queue {

  private LinkedList queue = new LinkedList();

  public void enQueue(Object obj){
    queue.add(obj);
  }

  public void deQueue(){
    queue.removeFirst();
  }

  public boolean isQueueEmpty(){
    return queue.isEmpty();
  }

  public boolean contains(Object obj){
    return queue.contains(obj);
  }

}
