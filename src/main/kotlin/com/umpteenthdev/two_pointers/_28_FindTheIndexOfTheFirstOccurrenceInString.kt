package com.umpteenthdev.two_pointers

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 *  or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 */
fun strStr(haystack: String, needle: String): Int {
    var needleIndex = 0
    var haystackIndex = 0

    while (haystackIndex < haystack.length && needleIndex < needle.length) {
        if (haystack[haystackIndex] == needle[needleIndex]) {
            haystackIndex++
            needleIndex++
            if (needleIndex == needle.length) {
                return haystackIndex - needleIndex
            }
        } else {
            haystackIndex = haystackIndex - needleIndex + 1
            needleIndex = 0
        }
    }

    return -1
}