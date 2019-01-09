/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  const res = []
  if (!nums || nums.length === 0) {
    return res
  }
  nums = nums.sort()
  helper(res, nums, [], [])
  return res
};

const helper = (res, nums, used, list) => {
  if (list.length === nums.length) {
    res.push([...list])
  }
  
  for (let i = 0; i < nums.length; i++) {
    if (used[i]) continue
    if (i > 0 && nums[i] === nums[i - 1] && !used[i - 1]) continue
    used[i] = true
    list.push(nums[i])
    helper(res, nums, used, list)
    used[i] = false
    list.pop()
  }
}

console.log(permuteUnique([1, 1, 1, 2]).toString())