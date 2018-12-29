var subsets = function (nums) {
  const totalArray = [[]];

  def(nums, []);
  return totalArray;

  function def(nums, array) {
    const length = nums.length;
    for (let i = 0; i < length; i++) {
      const newArray = array.slice(0);
      newArray.push(nums[i]);
      totalArray.push(newArray);
      def(nums.slice(i + 1, length), newArray);
    }
  }
};


// const subsets = function (nums) {
//   const res = []
//   nums = nums.sort(function (a, b) { return a - b })
//   helper(res, nums, [], 0)
//   return res
// }

// const helper = (res, nums, list, index) => {
//   res.push(list.slice())
//   for (let i = index; i < nums.length; i++) {
//     list.push(nums[i])
//     helper(res, nums, list, i + 1)
//     list.pop()
//   }
// }

console.log(subsets([1, 2, 10]).toString())
