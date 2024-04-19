package com.umpteenthdev.leetcode.tasks.two_pointers

import kotlin.math.log10

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
fun isHappy(n: Int): Boolean {
    var tortoise = n
    var hare = n

    while (true) {
        tortoise = calc(tortoise)
        hare = calc(hare)
        hare = calc(hare)

        if (hare == 1 || tortoise == 1) {
            return true
        }
        if (hare == tortoise) {
            return false
        }
    }
}

private fun calc(n: Int): Int {
    val length = if (n == 0) 1 else log10(n.toDouble()).toInt() + 1
    var c = n
    var r = 0
    repeat(length) {
        val d = c % 10
        r += d * d
        c /= 10
    }
    return r
}