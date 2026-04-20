package edu.xyf.codetop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Xuyifeng
 * @Description: 数组中的第 K 个最大元素
 * @Date: 2026/4/9 23:00
 */

public class Q4Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> list, int k) {
        Random random = new Random();
        int pivot = list.get(random.nextInt(list.size()));
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int x : list) {
            if (x > pivot) {
                big.add(x);
            } else if (x < pivot) {
                small.add(x);
            } else {
                equal.add(x);
            }
        }
        
        // 如果比基准值大的元素个数大于等于 k，说明第 k 大的元素在 big 集合中
        if (k <= big.size()) {
            return quickSelect(big, k);
        }
        
        // 计算大于和等于基准值的元素总数
        int bigAndEqual = big.size() + equal.size();
        
        // 如果 k 大于这个总数，说明第 k 大的元素在 small 集合中
        if (k > bigAndEqual) {
            // 在 small 集合中寻找减去 bigAndEqual 之后的第 (k - bigAndEqual) 大的元素
            return quickSelect(small, k - bigAndEqual);
        }
        
        // 否则，说明第 k 大的元素刚好就是基准值 pivot
        return pivot;
    }

}
