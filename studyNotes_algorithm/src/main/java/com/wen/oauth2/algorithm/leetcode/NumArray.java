package com.wen.oauth2.algorithm.leetcode;

/**
 * @author huwenwen
 * @since 16/8/17
 */
public class NumArray {

  private int[] nums;

  public NumArray(int[] nums) {
      this.nums = nums;
  }

  public int sumRange(int i, int j) {
    if(i < 0){
      return 0;
    }
    if(i > j){
      return 0;
    }
    if(j > nums.length - 1){
      j = nums.length - 1;
    }
    int sum = 0;
    for (int s = i; s <= j; s++) {
      sum += nums[s];
    }
    return sum;
  }

  public static void main(String[] args) {
    long l1 = System.currentTimeMillis();
    int[] nums = {1,2,4};
    NumArray num = new NumArray(nums);
    int i = num.sumRange(0, 0);
    long l2 = System.currentTimeMillis();
    // 0 1 2 3 4 5 7 8 9 10
    System.out.println(i + "===" + (l2 - l1));
  }
}
