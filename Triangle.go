package main

import "fmt"

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

// top -> bottom
func minimumTotal(triangle [][]int) int {
	n := len(triangle)
	f := make([][]int, n)
	for i := range f {
		f[i] = make([]int, i+1)
	}
	for i := 0; i < n; i++ {
		for j := 0; j <= i; j++ {
			if i == 0 && j == 0 {
				f[i][j] = triangle[i][j]
			} else if j == 0 { // 行首元素
				f[i][j] = triangle[i][j] + f[i-1][j]
				fmt.Println(f)
			} else if i == j { // 行尾元素
				f[i][j] = triangle[i][j] + f[i-1][j-1]
			} else {
				f[i][j] = triangle[i][j] + min(f[i-1][j], f[i-1][j-1])
			}
		}
	}
	return findMinVal(f[n-1])
}

// top -> bottom
func minimumTotal1(triangle [][]int) int {
	n := len(triangle)
	for i := 0; i < n; i++ {
		for j := 0; j <= i; j++ {
			if i == 0 && j == 0 {
				continue
			} else if j == 0 {
				triangle[i][j] += triangle[i-1][j]
			} else if i == j {
				triangle[i][j] += triangle[i-1][j-1]
			} else {
				triangle[i][j] += min(triangle[i-1][j], triangle[i-1][j-1])
			}
		}
	}
	return findMinVal(triangle[n-1])
}

// bottom -> top
func minimumTotal2(triangle [][]int) int {
	n := len(triangle)
	dp := make([]int, n+1)
	for i := n - 1; i >= 0; i-- {
		for j := 0; j <= i; j++ {
			dp[j] = min(dp[j], dp[j+1]) + triangle[i][j]
		}
	}
	return dp[0]
}

func findMinVal(array []int) int {
	min := array[0]
	for _, v := range array {
		if v < min {
			min = v
		}
	}
	return min
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	var triangle = [][]int{
		{2},
		{3, 4},
		{6, 5, 7},
		{4, 1, 8, 3},
	}
	ret := minimumTotal(triangle)
	fmt.Println(`@ret: `, ret)
}
