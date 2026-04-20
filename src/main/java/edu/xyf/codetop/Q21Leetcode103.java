package edu.xyf.codetop;

import edu.xyf.codetop.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Xuyifeng
 * @Description: 二叉树的锯齿形层序遍历
 * @Date: 2026/4/15 10:02
 */

public class Q21Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // true 为左->右，false 为右->左
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> path = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (flag) {
                    path.addLast(cur.val);
                } else {
                    path.addFirst(cur.val);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            flag = !flag;
            ans.add(path);
        }
        return ans;
    }

}
