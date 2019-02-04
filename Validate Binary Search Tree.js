/**
 * @param root: The root of binary tree.
 * @return: True if the binary tree is BST, or false
 */
const isValidBST = (root) => {
  return helper(root, null, null)
}

const helper = (root, min, max) => {
  if (root === null) return true
  if (min != null && root.val <= min || max != null && root.val >= max) {
    return false
  }
  return helper(root.left, min, root.val) && helper(root.right, root.val, max)
}