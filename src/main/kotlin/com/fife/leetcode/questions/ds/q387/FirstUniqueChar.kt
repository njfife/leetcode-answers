package com.fife.leetcode.questions.ds.q387

fun main() {

    val solution = Solution().firstUniqChar("this is my hot string")

    println("Index of first unique char: $solution")
}

class Solution {
    fun firstUniqChar(s: String): Int {
        val chars = mutableMapOf<Char, Int>()
        var firstUnique: Int = -1
        for (strIndex in s.indices) {
            if(chars[s[strIndex]] == -1) {
                continue
            }
            if(chars[s[strIndex]] == null) {
                chars[s[strIndex]] = strIndex
            } else {
                chars[s[strIndex]] = -1
            }
        }
        for (index in chars) {
            if ((firstUnique == -1 && index.value != -1) || index.value < firstUnique && index.value != -1) {
                firstUnique = index.value
            }
        }
        return -1
    }
}