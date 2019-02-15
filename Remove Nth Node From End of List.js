/**
 * @param head: The first node of linked list.
 * @param n: An integer
 * @return: The head of linked list.
 */
const removeNthFromEnd = function (head, n) {
  const dummy = {
    next: head
  }
  let slow = dummy, fast = head
  for (let i = 0; i < n; i++) {
    fast = fast.next
  }
  while (fast !== null) {
    fast = fast.next
    slow = slow.next
  }
  slow.next = slow.next.next
  return dummy.next
}