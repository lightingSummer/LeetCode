package array;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/24 0024
 * @description：
 */
public class 重塑矩阵566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int cnt = 0;
        int row = nums.length, column = nums[0].length;
        if (row * column != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        while (cnt < row * column) {
            res[cnt / c][cnt % c] = nums[cnt / column][cnt % column];
            cnt++;
        }
        return res;
    }
}
