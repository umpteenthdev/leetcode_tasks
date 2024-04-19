package com.umpteenthdev.dfs

import java.util.*

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
fun isSymmetric(root: TreeNode?): Boolean {
    return compareIterative(root?.left, root?.right)
}

private fun compareRecursive(l: TreeNode?, r: TreeNode?): Boolean {
    if (!isStructureSame(l, r)) {
        return false
    }
    if (l?.left != null || r?.right != null) {
        if (!compareRecursive(l?.left, r!!.right)) {
            return false
        }
    }

    if (l?.`val` != r?.`val`) {
        return false
    }

    if (l?.right != null || r?.left != null) {
        if (!compareRecursive(l?.right, r?.left)) {
            return false
        }
    }

    return true
}

private fun compareIterative(lRoot: TreeNode?, rRoot: TreeNode?): Boolean {
    val s = Stack<Pair<TreeNode, TreeNode>>()
    var l = lRoot
    var r = rRoot

    if (l?.`val` != r?.`val`) {
        return false
    }

    while (l != null || r != null || !s.empty()) {

        while (l != null || r != null) {
            if (!isStructureSame(l, r)) {
                return false
            }

            s.push(l!! to r!!)
            l = l.left
            r = r.right
        }

        with(s.pop()) {
            l = first
            r = second
        }
        if (l?.`val` != r?.`val`) {
            return false
        }

        l = l?.right
        r = r?.left
    }

    return true
}

private fun isStructureSame(l: TreeNode?, r: TreeNode?): Boolean {
    return (l == null) == (r == null)
}