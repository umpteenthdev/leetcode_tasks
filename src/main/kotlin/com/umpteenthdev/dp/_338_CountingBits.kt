package com.umpteenthdev.dp

import kotlin.math.min

/**
 * 0  0000 0
 *
 * 1  0001 1
 *
 * 2  0010 1
 * 3  0011 2
 *
 * 4  0100 1
 * 5  0101 2
 * 6  0110 2
 * 7  0111 3
 *
 * 8  1000 1
 * 9  1001 2
 * 10 1010 2
 * 11 1011 3
 * 12 1100 2
 * 13 1101 3
 * 14 1110 3
 * 15 1111 4
 *
 * 16 10000 1
 */
fun main() {
    println(countBits(20).joinToString())
}

fun countBits(n: Int): IntArray {
    val targetSize = n + 1
    val ans = IntArray(targetSize)
    var i = 0
    ans[i++] = 0
    var msb = 1

    while (i < targetSize) {
        val repCount = min(targetSize - i, msb)
        repeat(repCount) {
            ans[i] = ans[i - msb] + 1
            i++
        }
        msb = msb shl 1
    }

    return ans
}
