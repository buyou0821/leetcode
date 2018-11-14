class Test {
  public static void main(String[] args) {
    Solution s = new Solution();
    // int res = s.lengthOfLongestSubstring("ababcbb");
    int[] a = {1, 2};
    int[] b = {3, 4};
    double res = s.findMedianSortedArrays(b, a);
    System.out.println(res);
  }
}