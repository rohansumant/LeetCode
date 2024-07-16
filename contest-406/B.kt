/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun modifiedList(nums: IntArray, _head: ListNode?): ListNode? {
        val s = mutableSetOf<Int>()
        for (i in nums) s += i
        var head: ListNode? = null
        var prev: ListNode? = null
        var curr = _head
        while (curr != null) {
            if (curr.`val` !in s) {
                if (prev != null) {
                    prev.next = curr
                } else {
                    head = curr
                }
                prev = curr
            } else {
                if (prev != null) prev.next = null
            }
            curr = curr?.next
        }
        return head
    }
}
