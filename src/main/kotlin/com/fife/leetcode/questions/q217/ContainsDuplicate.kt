package com.fife.leetcode.questions.q217


fun main() {
    Solution().containsDuplicate(intArrayOf(2,3,4,43,22,434))
}

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val intSet: MutableSet<Int> = mutableSetOf()
        for(number in nums) {
            if (intSet.contains(number)) {
                return true
            } else {
                intSet.add(number)
            }
        }
        return false
    }
}