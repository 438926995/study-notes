package com.wen.oauth2.algorithm.leetcode;

/**
 * @author huwenwen
 * @since 16/8/15
 */
public class MoveZeroes {
  /**
   * 1 0 0 3 12
   * 1 0 0 3 12
   * 1 0 3 0 12
   * 1 0 3 12 0
   * 1 3 0 12 0
   * 1 3 12 0 0
   */
//  private static int[] nums = {0, 1, 0, 3, 12, 0 , 1, 3, 0, 2, 2, 0 ,2 ,2, 0, 0, 0, 12, 15, 0};
  private static int[] nums = {0, 0, 0, 0, 0, 1, 0, 0};

  /**
   * 1 0 3 12 0
   * 1 3 12 0 0
   *
   * @param nums
   */

  public void moveZeroes(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < nums.length - 1; j++) {
        int num = nums[j];
        if (num == 0) {
          nums[j] = nums[j + 1];
          nums[j + 1] = num;
        }
      }
    }
  }

  public static void main(String[] args) {
    MoveZeroes mz = new MoveZeroes();
    mz.moveZeroes(nums);
    for (int num : nums) {
      System.out.println(num);
    }
  }

}
