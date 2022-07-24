package com.fife.leetcode.questions.ds.q88

fun main() {
    val nums1 = intArrayOf(1,2,3,5,6,0)
    Solution().merge(nums1, 5, intArrayOf(4), 1)
    println(nums1.contentToString())
}

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        // Set p1 and p2 to point to the end of their respective arrays.
        var p1 = m - 1
        var p2 = n - 1

        // And move p backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (p in m + n - 1 downTo 0) {
            if (p2 < 0) {
                break
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--]
            } else {
                nums1[p] = nums2[p2--]
            }
        }
    }
}