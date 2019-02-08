/**
 * @param head: n
 * @return: The new head of reversed linked list.
 */
const reverse = function (head) {
  if (head == null) return head
  let prev = null
  while (head != null) {
    const temp = head.next
    head.next = prev
    prev = head
    head = temp
  }
  return prev 
}