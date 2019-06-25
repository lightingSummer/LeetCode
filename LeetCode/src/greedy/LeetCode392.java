package greedy;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description： 判断是否子序列
 */
public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }
        return i==s.length();
    }
}
