package edu.xyf.labuladong.train.list;

/**
 * @Author: Xuyifeng
 * @Description: 寻找重复数
 * @Date: 2026/4/20 21:48
 */

public class Leetcode287 {

    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow) {
                slow = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }

}
