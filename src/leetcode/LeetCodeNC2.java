package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/4/16 0016
 * @description：
 */
public class LeetCodeNC2 {
    public static void main(String[] args) {
        String S="aa";
        String T="a";
        System.out.println(minWindow(S,T));
    }
    public static String minWindow(String S, String T) {
        int[] map=new int[128];
        int left=0,right=0,count=T.length(),len=Integer.MAX_VALUE,head=0;
        for(char i:T.toCharArray())
            map[i]++;
        //右边指针往右移动
        while(right<S.length()){
            char temp=S.charAt(right);
            right++;
            if(map[temp]-->0)
                count--;
            while(count==0){
                //如果当前长度比以前小，取当前长度
                int tempLen=right-left;
                if(tempLen<len){
                    head=left;
                    len=tempLen;
                }
                //左指针往右移动
                int tempBegin=S.charAt(left);
                left++;
                if(map[tempBegin]++==0){
                    count++;
                }
            }
        }
        return len==Integer.MAX_VALUE?"":S.substring(head,head+len);
    }
}
