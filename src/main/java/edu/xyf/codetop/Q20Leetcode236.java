package edu.xyf.codetop;

import edu.xyf.codetop.struct.TreeNode;

/**
 * @Author: Xuyifeng
 * @Description: 二叉树的最近公共祖先
 * @Date: 2026/4/14 15:41
 */

public class Q20Leetcode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

}
