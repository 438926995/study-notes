package com.wen.junit;

/**
 * @author huwenwen
 * @since 16/7/26
 */
public class SyncThreadTest implements Runnable {

  // 特殊的instance变量
  private byte[] lock = new byte[0];
  private static int count;

  public SyncThreadTest() {
    count = 0;
  }

  public void run() {
    synchronized (lock) {
      for (int i = 0; i < 5; i++) {
        try {
          System.out.println(Thread.currentThread().getName() + ":" + (count++));
          Thread.sleep(1000);
        } catch (Exception e){

        }

      }
    }
  }

  public int getCount() {
    return count;
  }
}
