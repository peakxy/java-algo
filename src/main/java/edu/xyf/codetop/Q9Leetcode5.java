package edu.xyf.codetop;

/**
 * @Author: Xuyifeng
 * @Description: 最长回文子串
 * @Date: 2026/4/11 15:24
 */

public class Q9Leetcode5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            start = i;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

}
