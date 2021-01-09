package twoPointer;

import java.util.Collections;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/22 0022
 * @description：
 */
public class LeetCode524 {
    public String findLongestWord(String s, List<String> d) {
        String longestStr="";
        for(String str:d){
            int l1=longestStr.length();
            int l2=str.length();
            if(l1>l2 || l1==l2 && longestStr.compareTo(str)<0){
                continue;
            }
            if(isSub(s,str)){
                longestStr=str;
            }
        }
        return longestStr;
    }
    private boolean isSub(String s,String target){
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
