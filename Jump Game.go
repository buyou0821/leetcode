package leetcode

func canJump(nums []int) bool {
	max := nums[0]
	for i := 0; i < len(nums); i++ {
		if i > max {
			return false
		}
		// 当前索引+当前可以走的步数 和 之前索引中求出的可走步数的最大值 比较，即为当前可走到的最大索引位置
		if nums[i]+i > max {
			max = nums[i] + i
		}
	}
	return true
}
