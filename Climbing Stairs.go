package leetcode

func climbStairs(n int) int {
	dp := make([]int, n)
	dp[0] = 1
	for i := 1; i < n; i++ {
		if i <= 2 {
			dp[i] = dp[i-1] + 1
		} else {
			dp[i] = dp[i-1] + dp[i-2]
		}
	}
	return dp[n-1]
}
