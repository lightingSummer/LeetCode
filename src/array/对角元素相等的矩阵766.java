package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/26 0026
 * @description：
 */
public class 对角元素相等的矩阵766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        Set<Integer>[] nums = new Set[row + column - 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int num = matrix[i][j];
                int index = i - j + column - 1;
                if (nums[index] == null) {
                    nums[index] = new HashSet<>();
                    nums[index].add(num);
                }
                if (!nums[index].contains(num)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix1(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix, matrix[0][i], 0, i)) {
                return false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, matrix[i][0], i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] matrix, int expectValue, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length) {
            return true;
        }
        if (matrix[row][col] != expectValue) {
            return false;
        }
        return check(matrix, expectValue, row + 1, col + 1);
    }
}
