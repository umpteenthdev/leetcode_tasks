package com.umpteenthdev.leetcode.tasks.dfs

import kotlin.math.max

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Example 1:
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    return maxDepthRecursive(root, d = 1)
}

/**
 *       1
 *    2     2
 *  3  3  3   3
 */
fun maxDepthRecursive(n: TreeNode, d: Int): Int {
    var maxDepth = d
    if (n.left != null) {
        maxDepth = max(maxDepthRecursive(n.left!!, d + 1), maxDepth)
    }
    if (n.right != null) {
        maxDepth = max(maxDepthRecursive(n.right!!, d + 1), maxDepth)
    }
    return maxDepth
}