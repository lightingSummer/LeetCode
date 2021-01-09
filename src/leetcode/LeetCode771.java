package leetcode;

import java.util.Arrays;

/**
 * @author ：summerGit
 * @date ：2019/5/4 0004
 * @description：
 */
public class LeetCode771 {
    public int numJewelsInStones(String J, String S) {
        char[] j=J.toCharArray();
        char[] s=S.toCharArray();
        int count=0;
        for(int i=0;i<s.length;i++){
            for(int k=0;k<j.length;k++){
                if(j[k]==s[i]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
