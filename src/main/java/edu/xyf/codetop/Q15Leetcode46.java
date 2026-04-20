package edu.xyf.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 全排列
 * @Date: 2026/4/14 09:32
 */

public class Q15Leetcode46 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
