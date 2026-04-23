package edu.xyf.codetop;

/**
 * @Author: Xuyifeng
 * @Description: 字符串转换整数
 * @Date: 2026/4/22 17:29
 */

public class Q52Leetcode8 {

    public int myAtoi(String s) {
        int n = s.length();
        // 下标
        int i = 0;
        // 记录正负号
        int sign = 1;
        // 用 long 避免 int 溢出
        long res = 0;
        // 跳过前导空格
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        // 记录符号位
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        // 统计数字位
        while (i < n && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
            res = res * 10 + s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE) {
                break;
            }
            i++;
        }
        // 如果溢出，强转成 int 就会和真实值不同
        if ((int) res != res) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }

}
