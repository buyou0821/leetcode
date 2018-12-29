import java.util.ArrayList;

/*
78. Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    helper(res, list, nums, 0);
    return res;
  }

  public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
    res.add(new ArrayList<>(list));
    for (int i = index; i < nums.length; i++) {
      list.add(nums[i]);
      helper(res, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }
}