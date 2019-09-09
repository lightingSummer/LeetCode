package likedQuestions;

/**
 * @author     ：lightingSummer
 * @date       ：2019/9/9 0009
 * @description：
 */
public class 旋转图像048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 上下翻转
        for (int i =0; i < n /2 ; i++ ){
            for (int j =0; j < n; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
        // 对角翻转
        for (int i = 0; i < n; i ++){
            for (int j= i + 1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
