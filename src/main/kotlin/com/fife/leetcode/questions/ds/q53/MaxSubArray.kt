package com.fife.leetcode.questions.ds.q53

fun main() {
    val result = Solution().maxSubArray(intArrayOf(-2,1,-3,-222222222,-1,2,1,-5,4))
    println(result)
}

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var subarray = nums[0]
        var maxSubarray = nums[0]
        for (index in nums.indices) {
            if (index == 0) {
                continue
            }
            subarray = nums[index].coerceAtLeast(subarray + nums[index])
            maxSubarray = maxSubarray.coerceAtLeast(subarray)
        }
        return maxSubarray
    }
}