package greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description：  贪心算法 g children  s cookie
 * 思想 每次保证操作是最优的  最后的结果是最优的
 */
public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while (i<g.length && j<s.length){
            if(g[i] <= s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
