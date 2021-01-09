package array;

import java.util.PriorityQueue;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/24 0024
 * @description：
 */
public class 有序矩阵的KthElement378 {
    public int kthSmallest1(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[row - 1][column - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int kthSmallest(int[][] matrix, int k) {
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (queue.size() < k) {
                    queue.offer(matrix[i][j]);
                } else {
                    if (queue.peek() > matrix[i][j]) {
                        queue.poll();
                        queue.offer(matrix[i][j]);
                    }
                }
            }
        }
        return queue.poll();
    }
}
