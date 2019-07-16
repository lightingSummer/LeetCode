package math;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description：
 */
public class 二十六进制 {
    public String convertToTitle(int n) {
        if (n == 1) {
            return "A";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return sb.toString();
    }
}
