package com.umpteenthdev.leetcode.tasks.dfs

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val r = mutableListOf<Int>()
    if (root?.left != null) {
        r += inorderTraversal(root.left)
    }
    root?.`val`?.let(r::add)
    if (root?.right != null) {
        r += inorderTraversal(root.right)
    }
    return r
}

/**
 *  1 Go to the deepest node of the left branch
 *  2 Add current node to result list
 *  3 Remove node from the stack
 *  4 Move to the right node of current node
 */
fun inorderTraversalStack(root: TreeNode?): List<Int> {
    val r = mutableListOf<Int>()
    val s = Stack<TreeNode>()
    var current = root

    while (current != null || !s.empty()) {
        while (current != null) {
            s.push(current)
            current = current.left
        }

        current = s.pop()
        r += current.`val`
        current = current.right
    }

    return r
}
