package com.fife.leetcode.questions.ds.q383


fun main() {
    val solution = Solution().canConstruct("aaaaaa", "acab")
    println("Can Construct: $solution")
}

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (magazine.length < ransomNote.length) {
            return false
        }
        val noteMap = mutableMapOf<Char, Int>()
        val magMap = mutableMapOf<Char, Int>()
        for(noteLetter in ransomNote) {
           if (noteMap[noteLetter] == null) {
               noteMap[noteLetter] = 1
           } else {
               noteMap[noteLetter] = noteMap[noteLetter]!! + 1
           }
        }
        for (magLetter in magazine) {
            if (magMap[magLetter] == null) {
                magMap[magLetter] = 1
            } else {
                magMap[magLetter] = magMap[magLetter]!! + 1
            }
        }

        for(item in noteMap) {
            if (magMap[item.key] == null || magMap[item.key]!! < item.value) {
                return false
            }
        }
        return true
    }
}