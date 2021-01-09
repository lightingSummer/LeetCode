package likedQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author light
 * @date 30/11/2019 下午 4:06
 */
public class 螺旋矩阵054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int left = 0, up = 0, down = matrix.length - 1, right = matrix[0].length - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (up < down) {
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
            }
            if (left < right) {
                for (int i = down - 1; i > up; i--) {
                    res.add(matrix[i][left]);
                }
            }
            up++;
            right--;
            left++;
            down--;
        }
        return res;
    }
}
