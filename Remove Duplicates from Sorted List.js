// lintcode 112.

/**
 * @param head: head is the head of the linked list
 * @return: head of linked list
 */
const deleteDuplicates = function (head) {
  const dummyHead = {
    next: head
  }
  let cur = dummyHead
  while (cur.next && cur.next.next) {
    if (cur.next.val === cur.next.next.val) {
      cur.next = cur.next.next
    } else {
      cur = cur.next
    }
  }
  return dummyHead.next
}