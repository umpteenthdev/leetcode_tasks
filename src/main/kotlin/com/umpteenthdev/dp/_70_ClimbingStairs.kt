package com.umpteenthdev.dp

fun main() {
    val r = climbStairs(3)
    println(r)
}

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
fun climbStairs(n: Int): Int {
    // f(n) = f(n-1) + f(n-2)
    // 0 -> 1, 1 -> 1, 2 -> 2
    if (n == 0) {
        return 1
    }
    if (n == 1) {
        return 1
    }
    if (n == 2) {
        return 2
    }
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2

    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}