import com.sun.tools.javac.util.List;
import java.util.List;
class Test {
  public static void main(String[] args) {
    Solution s = new Solution();
    // int res = s.lengthOfLongestSubstring("ababcbb");

    // int[] a = {1, 2};
    // int[] b = {3, 4};
    // double res = s.findMedianSortedArrays(b, a);

    int[] arr = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> res = s.threeSum(arr);
    System.out.println(res);
  }
}