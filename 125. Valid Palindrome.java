/**
 * 
  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

  Note: For the purpose of this problem, we define empty string as valid palindrome.

  Example 1:

  Input: "A man, a plan, a canal: Panama"
  Output: true
  Example 2:

  Input: "race a car"
  Output: false
 */

class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0)
      return true;
    s = s.toLowerCase();
    int left = 0, right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
        left++;
      while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
        right--;
      if (s.charAt(left) != s.charAt(right))
        return false;
      left++;
      right--;
    }
    return true;
  }
}