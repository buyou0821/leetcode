package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sortedListToBST(head *ListNode) *TreeNode {
	if head == nil {
		return nil
	}
	if head.Next == nil {
		return &TreeNode{
			Val: head.Val,
		}
	}
	preMid := findPreMid(head)
	// root := &TreeNode{Val: preMid.Next.Val}
	var root *TreeNode = new(TreeNode)
	root.Val = preMid.Next.Val
	midAfter := preMid.Next.Next
	preMid.Next = nil
	root.Left = sortedListToBST(head)
	root.Right = sortedListToBST(midAfter)
	return root
}

func findPreMid(head *ListNode) *ListNode {
	slow, fast := head, head
	preMid := &ListNode{
		Next: slow,
	}
	for fast != nil && fast.Next != nil {
		preMid = preMid.Next
		slow = slow.Next
		fast = fast.Next.Next
	}
	return preMid
}
