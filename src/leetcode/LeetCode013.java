package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode013 {
    public int romanToInt(String s) {
        int[] res=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    res[i]=1000;
                    break;
                case 'D':
                    res[i]=500;
                    break;
                case 'C':
                    res[i]=100;
                    break;
                case 'L':
                    res[i]=50;
                    break;
                case 'X' :
                    res[i]=10;
                    break;
                case 'V':
                    res[i]=5;
                    break;
                case 'I':
                    res[i]=1;
                    break;
            }
        }
        int result=0;
        for(int i=0;i<res.length;i++){
            if(i<res.length-1 && res[i]<res[i+1]){
                result-=res[i];
            }
            else{
                result+=res[i];
            }
        }
        return result;
    }
}
