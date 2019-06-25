package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/25 0025
 * @description： 分割字符串 让相同的都在一起 且 尽量多
 * 贪心算法
 */
public class LeetCode763 {
    public static void main(String[] args) {
        String a= "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(a));
    }
    public static List<Integer> partitionLabels(String S) {
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexOfChar[S.charAt(i) - 'a'] = i;
        }
        int first = 0, last = 0, cur = 0;
        List<Integer> res = new ArrayList<>();
        while (cur < S.length()) {
            while (cur <= last) {
                int c = S.charAt(cur++);
                last = Math.max(last,lastIndexOfChar[c - 'a']);
            }
            res.add(last - first + 1);
            first = cur;
            last = cur;
        }
        return res;
    }
}
