package com.fife.leetcode.questions.ds.q118

fun main() {
    val result = Solution().generate(7)
    println(result)
}
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val triangle = mutableListOf<MutableList<Int>>()
        repeat(numRows) { row ->
            triangle.add(mutableListOf())
            repeat(row + 1) {
                if (it == 0 || it == row) {
                    triangle[row].add(1)
                } else {
                    triangle[row].add(
                        triangle[row - 1][it - 1] + triangle[row - 1][it]
                    )
                }
            }
        }
        return triangle
    }
}
