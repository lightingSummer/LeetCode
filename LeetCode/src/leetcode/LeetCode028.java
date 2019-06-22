package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/5/14 0014
 * @description：
 */
public class LeetCode028 {
    /**
     * @author: lightingSummer
     * @date: 2019/5/15 0015
     * @description: 最优算法应该是KMS
     * @param haystack
     * @param needle
     * @return int
     */
    public int strStr(String haystack, String needle) {
        int l1=haystack.length();
        int l2=needle.length();
        if(l1<l2){
            return -1;
        }else if(l2==0){
            return 0;
        }
        for(int i=0;i<=l1-l2;i++){
            if(haystack.substring(i,i+l2).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
