import java.util.ArrayList;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example: Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [2,3]
 */

/**
 * 循环数组，把当前循环到的vulue - 1(-1是因为根据题意避免数组越界)当作index 把index位置的元素置为负值，以标记该value出现了一次
 * 
 * 在之后的循环中，如果碰到index位置的元素为负，说明当前循环的value是重复出现了
 */
class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    ArrayList res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] < 0) {
        res.add(Math.abs(nums[i]));
      }
      nums[index] = -nums[index];
    }
    return res;
  }
}