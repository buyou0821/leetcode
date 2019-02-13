/**
 * @param head: ListNode head is the head of the linked list 
 * @param m: An integer
 * @param n: An integer
 * @return: The head of the reversed ListNode
 */
const reverseBetween = function (head, m, n) {
  if (head == null || m >= n) {
    return head
  }

  const dummy = {
    next: head
  }

  for (let i = 1; i < m - 1; i++) {
    if (head == null) {
      return null
    }
    head = head.next
  }

  const prevNode = head
  let prev = head.next
  let cur = prev.next
  const mNode = cur.next
  for (let i = m; i < n; i++) {
    temp = cur.next
    cur.next = prev
    prev = cur
    cur = temp
  }
  prevNode.next = mNode
  prev.next = cur

  return dummy.next
}