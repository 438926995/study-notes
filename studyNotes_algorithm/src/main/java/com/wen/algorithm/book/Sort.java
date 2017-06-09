package com.wen.algorithm.book;

import java.util.Random;

/**
 * @author huwenwen
 * @since 2017/6/6
 */
public class Sort {

  /**
   * 插入排序
   *
   * @param arrays
   */
  public void insertionSort(int[] arrays) {
    System.out.println("arrays length:" + arrays.length);
    long t1 = System.currentTimeMillis();
    for (int i = 1; i < arrays.length; i++) {
      int key = arrays[i];
      int j = i - 1;
      while (j >= 0 && arrays[j] > key) {
        arrays[j + 1] = arrays[j];
        j--;
      }
      arrays[j + 1] = key;
    }
    long t2 = System.currentTimeMillis();
    System.out.println("insertion-sort elapsed time " + (t2 - t1) + "ms");
  }

  public static void main(String[] args) {
    Random random = new Random();
    int length = 1000000;
    int[] arrays = new int[length];
    for (int i = 0; i< length; i++){
      arrays[i] = random.nextInt(1000000);
    }
//    int[] arrays = {2, 4, 6, 12, 78, 9, 0, 3, 3, 3, 6};
    new Sort().insertionSort(arrays);
//    System.out.println(JSON.toJSONString(arrays));
  }
}
