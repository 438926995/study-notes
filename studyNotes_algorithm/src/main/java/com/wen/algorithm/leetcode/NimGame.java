package com.wen.algorithm.leetcode;

/**
 * 介绍: 2人游戏,格子中有n块石头,每次可以拿出1,2或3块石头,最后一个拿完的人win
 * 你先拿, 有n块石头判断是否能赢
 *
 * @author huwenwen
 * @since 16/8/15
 */
public class NimGame {
  /**
   * 思路: 最后我拿了剩下4块我必赢
   *
   */
  public boolean canWinNim(int n){
//    if(n < 4){
//      return true;
//    } else if(n > 4){
//      return judgeGT4CanWin(n);
//    } else {
//      return false;
//    }
    return n%4 != 0;
  }

  public boolean judgeGT4CanWin(int n){

    return false;
  }
}
