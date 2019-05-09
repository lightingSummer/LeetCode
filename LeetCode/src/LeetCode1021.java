/**
 * @author ：summerGit
 * @date ：2019/5/7 0007
 * @description：
 */
public class LeetCode1021 {
    public static String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if(c!='(' && c!=')'){
                s.append(c);
            }
            else {
                if (c == '(' && opened++ > 0)
                    s.append(c);
                if (c == ')' && opened-- > 1)
                    s.append(c);
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String str="((123))";
        System.out.println(removeOuterParentheses(str));
    }
}
