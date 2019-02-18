/**
 * @param head: The first node of linked list.
 * @return: True if it has a cycle, or false
 */
const hasCycle = function (head) {
  if (head === null || head.next === null) {
    return false
  }
  let slow = head, fast = head.next
  while(slow !== fast) {
    if (fast == null || fast.next == null) {
      return false
    }
    fast = fast.next.next
    slow = slow.next
  }
  return true 
}
