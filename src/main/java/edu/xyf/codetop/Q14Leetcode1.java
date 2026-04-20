package edu.xyf.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xuyifeng
 * @Description: 两数之和
 * @Date: 2026/4/12 13:41
 */

public class Q14Leetcode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            if (map.containsKey(gap)) {
                return new int[]{i, map.get(gap)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

}
