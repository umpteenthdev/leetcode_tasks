package com.umpteenthdev.leetcode.tasks.two_pointers

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
fun reverseString(s: CharArray) {
    var i = 0
    var j = s.lastIndex
    var tmp: Char

    while (i < j) {
        tmp = s[j]
        s[j] = s[i]
        s[i] = tmp
        i++
        j--
    }
}