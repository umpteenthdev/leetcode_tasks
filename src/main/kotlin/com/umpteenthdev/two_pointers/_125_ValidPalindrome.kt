package com.umpteenthdev.two_pointers


/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
fun isPalindrome(s: String): Boolean {
    var head = 0
    var tail = s.length - 1

    while (head < s.length && tail >= 0 && head <= tail) {
        if (!isAlphanumeric(s[head])) {
            head++
        } else if (!isAlphanumeric(s[tail])) {
            tail--
        } else {
            if (lowercase(s[head]) != lowercase(s[tail])) {
                return false
            } else {
                head++
                tail--
            }
        }
    }
    return true
}

private fun isAlphanumeric(c: Char): Boolean {
    val digitChars = '0'..'9'
    val capitalLetterChars = 'A'..'Z'
    val letterChars = 'a'..'z'
    return c in digitChars || c in capitalLetterChars || c in letterChars
}

private fun lowercase(c: Char): Char {
    val capitalLetterChars = 'A'..'Z'
    val lowercaseDiff = 'a'.code - 'A'.code
    return if (c in capitalLetterChars) {
        c + lowercaseDiff
    } else {
        c
    }
}