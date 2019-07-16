package math;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/15 0015
 * @description：
 */
public class 七进制数 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = num * (-1);
        }
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        return flag ? "-" + sb.reverse().toString() : sb.reverse().toString();
    }
}
