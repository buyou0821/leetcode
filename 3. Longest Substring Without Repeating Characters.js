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

/**
* @param {string} s
* @return {number}
*/
var lengthOfLongestSubstring = function (s) {
  const dict = {}
  let size = 0
  for (let i = 0, j = 0; i < s.length; i++) {
    if (dict[s[i]] >= 0) {
      j = Math.max(j, dict[s[i]] + 1)
    }
    dict[s[i]] = i
    size = Math.max(size, i - j + 1)
  }
  return size
};

var lengthOfLongestSubstring2 = function (s) {
  const set = new Set()
  let size = 0
  for (let i = 0, j = 0; i < s.length;) {
    if (set.has(s[i])) {
      set.delete(s[j++])
    } else {
      set.add(s[i++])
      size = Math.max(size, set.size)
    }
  }
  return size
};

console.log(lengthOfLongestSubstring2('ababcbb'))

