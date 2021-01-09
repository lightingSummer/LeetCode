package likedQuestions;

/**
 * @author     ：lightingSummer
 * @date       ：2019/9/9 0009
 * @description：
 */
public class 接雨水042 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < n - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
            right[n - i - 1] = Math.max(height[n - i], right[n - i]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(left[i], right[i]);
            res += min > height[i] ? min - height[i] : 0;
        }

        return res;
    }
}
