package com.umpteenthdev.dfs

import java.util.*

/**
 * Recursive
 */
fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

    var r = true

    if ((p?.left == null) != (q?.left == null)) {
        return false
    }
    if (p?.left != null) {
        r = r && isSameTree(p.left, q!!.left)
    }

    if (p?.`val` != q?.`val`) {
        return false
    }

    if ((p?.right == null) != (q?.right == null)) {
        return false
    }
    if (p?.right != null) {
        r = r && isSameTree(p.right, q!!.right)
    }

    return r
}

/**
 * Stack
 */
fun isSameTreeStack(p: TreeNode?, q: TreeNode?): Boolean {
    val s = Stack<Pair<TreeNode, TreeNode>>()
    var pCur = p
    var qCur = q

    if ((pCur == null) != (qCur == null)) {
        return false
    }

    while (pCur != null || !s.empty()) {

        while (pCur != null) {
            s.push(pCur to qCur!!)
            pCur = pCur.left
            qCur = qCur.left
            if ((pCur == null) != (qCur == null)) {
                return false
            }
        }

        with(s.pop()) {
            pCur = first
            qCur = second
        }

        if (pCur?.`val` != qCur?.`val`) {
            return false
        }

        pCur = pCur?.right
        qCur = qCur?.right

        if ((pCur == null) != (qCur == null)) {
            return false
        }
    }

    return true
}