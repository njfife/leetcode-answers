package com.fife.leetcode.questions.ds.q121

fun main() {
    val result = Solution().maxProfit(intArrayOf(7,1,5,3,6,4))
    println("Result: $result")
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var maxProfit = 0
        for (i in prices.indices) {
            val n = prices[i]
            if (n < min) {
                min = n
            } else if (maxProfit < (n - min)) {
                maxProfit = (n - min)
            }
        }
        return maxProfit
    }
}
