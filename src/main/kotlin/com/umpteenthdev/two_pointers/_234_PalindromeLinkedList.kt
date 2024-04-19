package com.umpteenthdev.two_pointers

fun main() {
    val r = isPalindrome(
        ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(1)
            }
        }
    )
    println(r)
}

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
fun isPalindrome(head: ListNode?): Boolean {
    // calc size
    var size = 0
    var p1 = head
    while (p1 != null) {
        size++
        p1 = p1.next
    }

    // reverse head
    val center = (size + 1) / 2
    p1 = head
    var prev: ListNode? = null
    var next: ListNode? = null

    repeat(center) {
        next = p1?.next
        p1?.next = prev
        prev = p1
        p1 = next
    }

    // set start points
    var p2: ListNode? = null
    if (size % 2 == 0) {
        p2 = p1
        p1 = prev
    } else {
        p1 = prev?.next
        p2 = next
    }

    // compare head and tail
    while (!(p1 == null && p2 == null)) {
        if (p1?.`val` != p2?.`val`) {
            return false
        }
        p1 = p1?.next
        p2 = p2?.next
    }

    return true
}