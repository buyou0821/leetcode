import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3. Example 2:
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
 * 1. Example 3:
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 */

class Solution {
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int size = 0;
    for (int i = 0, j = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        j = Math.max(map.get(s.charAt(i)) + 1, j);
      }
      map.put(s.charAt(i), i);
      size = Math.max(i - j + 1, size);
    }
    return size;
  }
}

// ababcbb
public class Solution {
  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }
}

// ababcbb
class Solution1 {
  public int lengthOfLongestSubstring(String s) {
    int res = 0;
    if (s == null || s.length() == 0)
      return res;
    Set<Character> set = new HashSet<>();
    for (int i = 0, j = 0; i < s.length();) {
      if (set.contains(s.charAt(i))) {
        set.remove(s.charAt(j++));
      } else {
        set.add(s.charAt(i++));
        res = Math.max(res, set.size());
      }
    }
    return res;
  }
}

