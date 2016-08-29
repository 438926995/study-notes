package com.wen.oauth2.algorithm.leetcode;

/**
 * @author huwenwen
 * @since 16/8/15
 */
public class Solution {
  public int getSum(int a, int b) {
    while (true) {
      if (b == 0) {
        return a;
      }
      int temp = a ^ b;
      b = (a & b) << 1;
      a = temp;
    }
    //    return new BigDecimal(a).add(new BigDecimal(b)).intValue();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.getSum(8, 2));
    System.out.println(4 << 1);
  }

}
