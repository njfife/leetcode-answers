package com.fife.leetcode.questions

fun main() {
    // INPUT:
    //[2,4,3]
    //[5,6,4]
    // Expected:
    // [7,0,8]
    val nodeOneNumOne: ListNode? = buildListNodeNumber(9)
    val nodeTwoNumTwo: ListNode? = buildListNodeNumber(465)
    val result = FirstAttempt().addTwoNumbers(
        l1 = nodeOneNumOne,
        l2 = nodeTwoNumTwo
    )
    println("Test ended with: " + convertToNumber(result))
    validateResult(result, 807)
    println("Test Ended Successfully.")
}

fun validateResult(result: ListNode?, expected: Int) {
    buildListNodeNumber(expected)
    var currNode: ListNode? = result!!
    expected.toString().reversed().forEach {
        if(currNode != null && it.toString().toInt() != currNode?.`val`) {
            throw RuntimeException("VALIDATE FAILED")
        }
        currNode = currNode?.next
    }
}

fun buildListNodeNumber(number: Int): ListNode? {
    val firstNode = ListNode(0)
    var currNode = firstNode
    val numStr = number.toString().reversed()
    numStr.forEachIndexed { index, digit ->
        currNode.`val` = digit.toString().toInt()
        if (index < numStr.length - 1) {
            currNode.next = ListNode(0)
            currNode = currNode.next!!
        }
    }
    return firstNode
}

fun convertToNumber(listNode: ListNode?): Int {
    val number: StringBuilder = StringBuilder()
    var currNode: ListNode? = listNode
    while (currNode != null) {
        number.append(currNode.`val`)
        currNode = currNode.next
    }
    return number.toString().reversed().toInt()
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class FirstAttempt {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return buildListNodeNumber(convertToNumber(l1) + convertToNumber(l2))
    }
}