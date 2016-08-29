package com.wen.oauth2.algorithm.leetcode;

/**
 * @author huwenwen
 * @since 16/8/15
 */
public class ReverseString {

  public String reverseString(String str) {
    char[] chars = str.toCharArray();
    StringBuilder result = new StringBuilder(str.length());
    for (int i = chars.length - 1; i >= 0; i--) {
      result.append(chars[i]);
    }
    return result.toString();
  }

  public static void main(String[] args) {

    System.out.println(new ReverseString().reverseString("race car"));
  }
}
