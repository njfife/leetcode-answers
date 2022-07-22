package com.fife.leetcode.questions.q88

fun main() {
    val nums1 = intArrayOf(4,5,6,0,0,0)
    Solution().merge(nums1, 3, intArrayOf(1,2,3), 3)
    for (n in nums1) {
        print("$n,")
    }
}

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var index2 = 0
        var index1offset = 0
        for (i in nums1.indices) {
            val index1 = i + index1offset
            if (nums1[index1] <= nums2[index2] && nums1[index1] != 0) {
                continue
            } else {
                val n1 = nums1[index1]
                nums1[index1] = nums2[index2]
                nums2[index2] = n1
            }
        }
    }
}