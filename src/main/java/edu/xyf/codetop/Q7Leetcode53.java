package edu.xyf.codetop;

/**
 * @Author: Xuyifeng
 * @Description: 最大子数组和
 * @Date: 2026/4/11 15:08
 */

public class Q7Leetcode53 {

    public int maxSubArray(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        ans = dp[0];
        if (nums.length == 1) {
            return dp[0];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

}
