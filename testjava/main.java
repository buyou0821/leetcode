import java.util.List;
class LC {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> res = new Solution().subsets(nums);
    System.out.println(res);
  }
}