package com.fife.leetcode.questions

fun main() {
    val target = 6
    val intArray = IntArray(5).also {
        it[0] = 3
        it[1] = 4
        it[2] = 5
        it[3] = 3
        it[4] = 4
    }
    val indexes = OnePassHashmap().twoSum(intArray, target)!!
    if ((intArray[indexes[0]] + intArray[indexes[1]]) != target) {
        throw RuntimeException("Target Didn't Match")
    } else {
        println("Target Found")
    }
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indexArray = IntArray(2)

        for ((index1, num1) in nums.withIndex()) {
            for ((index2, num2) in nums.withIndex()) {
                if(index1 <= index2) {
                    break
                }
                if (num1 + num2 == target) {
                    indexArray[0] = index1
                    indexArray[1] = index2
                    return indexArray
                }
            }
        }
        return indexArray
    }
}

class HashmapSolution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indexArray = IntArray(2)
        val numMap = mutableMapOf<Int, Set<Int>>()
        for ((index, num) in nums.withIndex()) {
            if (!numMap.contains(num)) {
                numMap[num] = mutableSetOf()
            }
            (numMap[num] as MutableSet<Int>).add(index)
        }
        for ((index, num) in nums.withIndex()) {
            val neededNumber: Int = target - num
            if (numMap.contains(neededNumber)) {
                val indexes = numMap[neededNumber]!!
                if (indexes.size == 1 && indexes.contains(index)) {
                    continue
                }
                indexArray[0] = index
                indexArray[1] = indexes.first {
                    it != index
                }
                return indexArray
            }
        }
        throw RuntimeException("Target Didn't Match")
    }
}

class OnePassHashmap {
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val map: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }
        return null
    }
}