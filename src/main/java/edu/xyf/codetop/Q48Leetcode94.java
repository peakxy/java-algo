package edu.xyf.codetop;

import edu.xyf.codetop.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Xuyifeng
 * @Description: 二叉树的中序遍历
 * @Date: 2026/4/22 10:48
 */

public class Q48Leetcode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            root = treeNode.right;
        }
        return res;
    }

}
