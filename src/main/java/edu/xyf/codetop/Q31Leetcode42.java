package edu.xyf.codetop;

/**
 * @Author: Xuyifeng
 * @Description: 接雨水
 * @Date: 2026/4/17 10:09
 */

public class Q31Leetcode42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0;
        int n = height.length;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }
        for (int i = 1; i < n; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }

}
