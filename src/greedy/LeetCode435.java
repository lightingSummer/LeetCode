package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description： 不重叠的区间个数
 * 先对数组按照start进行排序
 * 然后如果end>start 就删除那个end大的
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
public class LeetCode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length==0 || intervals[0].length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int cnt = 0;
        int tempEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(tempEnd>intervals[i][0]){
                cnt++;
                tempEnd = Math.min(tempEnd,intervals[i][1]);
            }else{
                tempEnd = intervals[i][1];
            }
        }
        return cnt;
    }
}
