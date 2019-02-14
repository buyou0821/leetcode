/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reorderList(head *ListNode) {
	if head == nil || head.Next == nil {
		return
	}
	mid := findMid(head)
	right := reverse(mid.Next)
	mid.Next = nil
	merge(head, right)
}

func merge(left *ListNode, right *ListNode) *ListNode {
	index := 0
	dummy := new(ListNode)
	head := dummy
	for left != nil && right != nil {
		if index%2 == 0 {
			head.Next = left
			left = left.Next
		} else {
			head.Next = right
			right = right.Next
		}
		head = head.Next
		index++
	}
	if left != nil {
		head.Next = left
	} else {
		head.Next = right
	}
	return dummy.Next
}

func findMid(head *ListNode) *ListNode {
	slow, fast := head, head.Next
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}
	return slow
}

func reverse(head *ListNode) *ListNode {
	var prev *ListNode = nil
	for head != nil {
		temp := head.Next
		head.Next = prev
		prev = head
		head = temp
	}
	return prev
}