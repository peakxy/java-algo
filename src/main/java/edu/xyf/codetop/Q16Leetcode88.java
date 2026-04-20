package edu.xyf.codetop;

/**
 * @Author: Xuyifeng
 * @Description: 合并两个有序数组
 * @Date: 2026/4/14 09:39
 */

public class Q16Leetcode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int p = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p] = nums1[i];
                i--;
            } else {
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }
        while (j >= 0) {
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }

}
