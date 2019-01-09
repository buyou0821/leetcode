/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
  const row = matrix.length
  const column = matrix[0].length
  let left = 0, right = row * column
  while (left <= right) {
    const mid = left + Math.floor((right - left) / 2)
    const midVal = matrix[Math.floor(mid / column)][Math.floor(mid % column)]
    if (midVal === target) {
      return true
    } else if (midVal < target){
      left = mid + 1
    } else {
      right = mid - 1
    }
  }
  return false
}
