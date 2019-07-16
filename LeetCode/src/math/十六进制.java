package math;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description：
 */
public class 十六进制 {
    public static void main(String[] args) {
        System.out.println(toHex(26));
    }

    public static String toHex(int num) {
        if (num == 0) return "0";
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            sb.insert(0, map[num & 0b1111]);
            num >>>= 4;
        }
        return sb.toString();
    }
}
