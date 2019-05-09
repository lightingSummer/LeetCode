/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode009 {
    /**
     * author: summerGit
     * date: 2019/5/8 0008
     * description: Determine whether an integer is a palindrome.
     * An integer is a palindrome when it reads the same backward as forward.
     */
    public boolean isPalindrome(int x) {
        String num=String.valueOf(x);
        return new StringBuilder(num).reverse().toString().equals(num);
    }
}
