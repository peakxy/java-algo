package edu.xyf.codetop;

/**
 * @Author: Xuyifeng
 * @Description: 买卖股票的最佳时机
 * @Date: 2026/4/14 14:08
 */

public class Q18Leetcode121 {

    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for (int p : prices) {
            ans = Math.max(ans, p - minPrice);
            minPrice = Math.min(minPrice, p);
        }
        return ans;
    }

}
