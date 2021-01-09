package string;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/22 0022
 * @description： 不转为字符串来求解
 */
public class 判断回文数09 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        } else if (x == 0) {
            return true;
        }
        int temp = 0;
        while (temp < x) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        return x == temp || temp / 10 == x;
    }
}
