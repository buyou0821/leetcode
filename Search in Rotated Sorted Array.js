const search = function (A, target) {
  let left = 0, right = A.length - 1
  while (left <= right) {
    const mid = left + ~~((right - left) / 2)
    if (A[mid] === target) {
      return mid
    } else if (A[left] < A[mid]) {
      if (target < A[left] && target < A[mid]) {
        right = mid - 1
      } else {
        left = mid + 1
      }
    } else {
      if (A[left] > target && target > A[mid]) {
        right = mid - 1
      } else {
        left = mid + 1
      }
    }
  }
  return -1;
}
