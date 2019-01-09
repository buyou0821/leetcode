/**
 46. Permutations
  Given a collection of distinct integers, return all possible permutations.
  Example:
  Input: [1,2,3]
  Output:
  [
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
  ]
 */

 /**
 * @param {number[]} nums
 * @return {number[][]}
 */
const permute = (nums) => {
  const res = []
  helper(res, [], nums)
  return res
}

const helper = (res, list, nums) => {
  if (list.length === nums.length) {
    res.push(list.slice())
  }
  for (let i = 0; i < nums.length; i++) {
    if (list.includes(nums[i])) {
      continue
    }
    list.push(nums[i])
    helper(res, list, nums)
    list.pop()
  }
}

 /**
 * @param {number[]} nums
 * @return {number[][]}
 */
const permute2 = (nums) => {
  const res = []
  helper(res, [], [], nums)
  return res
}

const helper2 = (res, used, list, nums) => {
  if (list.length === nums.length) {
    res.push(list.slice())
  }
  for (let i = 0; i < nums.length; i++) {
    if (!used[i]) {
      used[i] = true
      list.push(nums[i])
      helper(res, used, list, nums)
      list.pop()
      used[i] = false
    }
  }
}