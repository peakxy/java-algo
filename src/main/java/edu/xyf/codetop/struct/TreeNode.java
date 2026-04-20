package edu.xyf.codetop.struct;

/**
 * @Author: Xuyifeng
 * @Description: 二叉树
 * @Date: 2026/4/12 13:05
 */

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
