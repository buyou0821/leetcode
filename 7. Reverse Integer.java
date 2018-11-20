/**
 * Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:
    Input: 123
    Output: 321

    Example 2:
    Input: -123
    Output: -321

    Example 3:
    Input: 120
    Output: 21
    Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

class Solution {
  public int reverse(int x) {
    int ret = 0;
    while (x != 0) {
      int lastDigit = x % 10;
      int tempRet = ret * 10 + lastDigit;
      // overflow
      if ((tempRet - lastDigit) / 10 != ret)
        return 0;
      ret = tempRet;
      x /= 10;
    }
    return ret;
  }
}