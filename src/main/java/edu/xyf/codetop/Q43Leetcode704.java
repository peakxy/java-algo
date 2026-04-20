package edu.xyf.codetop;

/**
 * @Author: Xuyifeng
 * @Description: 二分查找
 * @Date: 2026/4/20 10:34
 */

public class Q43Leetcode704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
