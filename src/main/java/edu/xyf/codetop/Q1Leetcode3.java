package edu.xyf.codetop;

/**
 * @Author: Xuyifeng
 * @Description: 无重复字符的最长子串
 * @Date: 2026/4/9 22:18
 */

public class Q1Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] cnt = new int[128];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            cnt[s.charAt(right)]++;
            while (cnt[s.charAt(right)] > 1) {
                cnt[s.charAt(left)]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
