package com.fife.leetcode.questions.ds.q36

fun main() {
    val board = arrayOf(
        charArrayOf('5','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.'),
        charArrayOf('8','.','.','.','6','.','.','.','3'),
        charArrayOf('4','.','.','8','.','3','.','.','1'),
        charArrayOf('7','.','.','.','2','.','.','.','6'),
        charArrayOf('.','6','.','.','.','.','2','8','.'),
        charArrayOf('.','.','.','4','1','9','.','.','5'),
        charArrayOf('.','.','.','.','8','.','.','7','9')
    )

    val solution = Solution().isValidSudoku(board)

    for (row in board) {
        println(row.contentToString())
    }

    println("Board valid: $solution")
}

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows: Array<MutableSet<Char>> = Array(9) {
            mutableSetOf()
        }
        val cols: Array<MutableSet<Char>> = Array(9) {
            mutableSetOf()
        }
        val boxes: Array<MutableSet<Char>> = Array(9) {
            mutableSetOf()
        }

        for (rowIndex in board.indices) {
            for (colIndex in board[rowIndex].indices) {
                val num = board[rowIndex][colIndex]
                val boxIndex: Int = ((rowIndex / 3) * 3) + (colIndex) / 3
                if (num == '.') {
                    continue
                }
                if (!(rows[rowIndex].add(num) && cols[colIndex].add(num) && boxes[boxIndex].add(num))) {
                    return false
                }
            }
        }
        return true
    }
}