package com.fife.leetcode.questions.q4

//main function
fun main() {
    val result = Solution().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2, 4))
    println(result)
}

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val nums = nums1.plus(nums2)
        nums.sort()
        val size = nums.size
        return if (size % 2 == 0) {
            (nums[size / 2] + nums[size / 2 - 1]) / 2.0
        } else {
            nums[size / 2].toDouble()
        }
    }
}