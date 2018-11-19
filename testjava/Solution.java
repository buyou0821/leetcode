import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.sun.tools.javac.util.List;
// ababcbb
public class Solution {
  public int lengthOfLongestSubstring(String s) {
    int res = 0;
    HashSet<Character> set = new HashSet<>();
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
  // no.4
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) return (findMedianSortedArrays(nums2, nums1));
    int len = nums1.length + nums2.length;
    int cutL = 0;
    int cutR = nums1.length;
    int cut1 = 0;
    int cut2 = 0;
    while (cutL <= cutR) {
      cut1 = (cutR - cutL) / 2 + cutL;
      cut2 = len / 2 - cut1;
      double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
      double R1 = cut1 == 0 ? Integer.MAX_VALUE : nums1[cut1];
      double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
      double R2 = cut2 == 0 ? Integer.MAX_VALUE : nums2[cut2];
      if (L1 > R2) {
        cutR = cut1 - 1;
      } else if (L2 > R1) {
        cutL = cut1 + 1;
      } else {
        if (len % 2 == 0) {
          double L = L1 > L2 ? L1 : L2;
          double R = R1 < R2 ? R1 : R2;
          return (L + R) / 2;
        } else {
          double R = R1 < R2 ? R1 : R2;
          return  R / 2;
        }
      }
    }
    return -1;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
      while (low < high) {
        if (nums[low] + nums[high] == sum) {
          res.add(Arrays.asList(nums[i], nums[low], nums[high]));
          while (low < high && nums[low] == nums[low + 1])
            low++;
          while (low < high && nums[high] == nums[high - 1])
            high--;
          low++;
          high--;
        } else if (nums[low] + nums[high] < sum) {
          low++;
        } else {
          high--;
        }
      }
    }
    return res;
  }
}
