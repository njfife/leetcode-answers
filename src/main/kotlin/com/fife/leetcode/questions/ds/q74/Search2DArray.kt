package com.fife.leetcode.questions.ds.q74

fun main() {
    // [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3

    val matrix = arrayOf(
        intArrayOf(1,3,5,7),
        intArrayOf(10,11,16,20),
        intArrayOf(23,30,34,60)
    )

    val matrix1 = arrayOf(intArrayOf(1))

    val solution = Solution().searchMatrix(
        matrix = matrix1,
        target = 1
    )

    for (array in matrix) {
        println(array.contentToString())
    }

    println("Number found: $solution")
}

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (arrayIndex in matrix.indices) {
            val array = matrix[arrayIndex]
            if (array[array.size - 1] >= target) {
                return array.binarySearch(target) >= 0
            }
        }
        return false
    }
}