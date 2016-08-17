package com.wen.junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author huwenwen
 * @since 16/7/25
 */
public class JavaTest {

  private final static Logger logger = LoggerFactory.getLogger(JavaTest.class);

  public static void main(String[] args) throws ParseException {
    //    SyncThreadTest s = new SyncThreadTest();
    //    SyncThreadTest s2 = new SyncThreadTest();
    //    Thread t1 = new Thread(s, "SyncThread1");
    //    Thread t2 = new Thread(s2, "SyncThread2");
    //    t1.start();
    //    t2.start();
    //    LocalDate date = new LocalDate(2016, 7, 28);
    List<Integer> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer("hello,kkk", ",");
    System.out.println(st.nextToken());
    System.out.println(st.nextToken());
    logger.info("================");
    logger.info("hello{}", "wenwen");
  }
}
