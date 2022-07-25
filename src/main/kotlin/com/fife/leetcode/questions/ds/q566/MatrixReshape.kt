package com.fife.leetcode.questions.ds.q566

fun main() {
    val reshaped = Solution().matrixReshape(arrayOf(
        intArrayOf(1,2),
        intArrayOf(3,4)
    ), 2, 4)

    for (row in reshaped) {
        println(row.contentToString())
    }

}
class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if (mat.size * mat[0].size != r * c) {
            return mat
        }
        val reshapedArray = Array(r) {
            IntArray(c)
        }
        var newArrayRow = 0
        var newArrayCol = 0
        for (rowIndex in mat.indices) {
            val row = mat[rowIndex]
            for (colIndex in row.indices) {
                if (newArrayCol > c - 1) {
                    newArrayRow++
                    newArrayCol = 0
                }
                reshapedArray[newArrayRow][newArrayCol] = row[colIndex]
                newArrayCol++

            }
        }
        return reshapedArray
    }
}
