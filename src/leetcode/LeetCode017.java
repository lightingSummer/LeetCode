package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：summerGit
 * @date ：2019/5/12 0012
 * @description：
 */
public class LeetCode017 {
    public static void main(String[] args) {
        String digits="93";
        System.out.println(letterCombinations(digits));
    }
    public static List<String> letterCombinations(String digits) {
        char[][] letters={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
                {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<String> result=new ArrayList<>();
        if(digits==null || digits.length()==0){
            return result;
        }
        StringBuilder sb=new StringBuilder();
        dfs(digits,letters,sb,result,0);
        return result;
    }
    public static void dfs(String digits,char[][] letters,StringBuilder sb,List<String> result,int index){
        if(index>=digits.length()){
            result.add(sb.toString());
            return;
        }
        int num=digits.charAt(index)-'2';
        for(int i=0;i<letters[num].length;i++){
            sb.append(letters[num][i]);
            dfs(digits,letters,sb,result,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
