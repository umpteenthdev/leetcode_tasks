package com.umpteenthdev.two_pointers

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun hasCycle(head: ListNode?): Boolean {
    var tortoise = head
    var hare = head

    while (true) {
        tortoise = tortoise?.next
        hare = hare?.next?.next
        if (hare == null) {
            return false
        } else if (hare == tortoise) {
            return true
        }
    }
}