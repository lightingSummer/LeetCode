package greedy;

import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description：
 * 给你一堆气球，这些气球沿X轴方向摆放，每个气球大小可能不同，一个气球占据的区间可以表示为[Xstart,Xend]，气球可以重叠摆放。
 * 一支坐标为x的箭，可以扎破所有满足 Xstart <= x <= Xend 的气球，求出最少射几支箭可以将所有气球扎破。
 */
public class LeetCode452 {
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        int cnt = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (end >= points[i][0]) {
                end = Math.min(end, points[i][1]);
            } else {
                cnt++;
                end = points[i][1];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }
}
