var searchInsert = function(nums, target) {
  let left = 0, right = nums.length - 1
  while (left <= right) {
    const mid = left + Math.floor((right - left) / 2)
    const midVal = nums[mid]
    if (midVal === target) {
      return mid
    } else if (midVal < target) {
      left = mid + 1
    } else {
      right = mid - 1
    }
  }
  return left
};

console.log(searchInsert([1,3,5,6], 4)) // 2