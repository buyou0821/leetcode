import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) return  res;
    helper(res, new ArrayList<>(), nums, 0);
    return res;
  }
  public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
    res.add(new ArrayList<>(list));
    System.out.println("res: " + res);
    for (int i = index; i < nums.length; i++) {
      list.add(nums[i]);
      System.out.println("list: " + list);
      helper(res, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
