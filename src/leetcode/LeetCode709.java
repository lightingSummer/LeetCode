package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/5/7 0007
 * @description：
 */
public class LeetCode709 {
    public String toLowerCase(String str) {
        StringBuilder sb=new StringBuilder();
        for(char c:str.toCharArray()){
            if(c>='A' && c<='Z'){
                sb.append((char) (c+32));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
