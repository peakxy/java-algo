package edu.xyf.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Xuyifeng
 * @Description: 螺旋矩阵
 * @Date: 2026/4/15 10:26
 */

public class Q23Leetcode54 {

    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>(m * n);
        int i = 0;
        int j = 0;
        int di = 0;
        for (int k = 0; k < m * n; k++) {
            ans.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE;
            int x = i + dirs[di][0];
            int y = j + dirs[di][1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == Integer.MAX_VALUE) {
                di = (di + 1) % 4;
            }
            i += dirs[di][0];
            j += dirs[di][1];
        }
        return ans;
    }

}
