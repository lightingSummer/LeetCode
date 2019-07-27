package array;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/27 0027
 * @description：
 */
public class 分隔数组769 {
    public int maxChunksToSorted(int[] arr) {
        int cnt = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(arr[i], right);
            if (right == i) {
                cnt++;
            }
        }
        return cnt;
    }
}
