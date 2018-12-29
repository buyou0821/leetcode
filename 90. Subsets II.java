import java.awt.List;
import java.util.ArrayList;

/**
 * 90. Subsets II
 * Given a collection of integers that might contain duplicates,
 * nums, return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: [1,2,2]
 * Output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 */

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    helper(res, nums, new ArrayList<>(), 0);
    return res;
  }

  public void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {
      res.add(new ArrayList<>(list));
      for (int i = index; i < nums.length; i++) {
        if (i != index && nums[i] == nums[i - 1]) continue;
        list.add(nums[i]);
        helper(res, nums, list, i + 1);
        list.remove(list.size() - 1);
      }
  }
}