package dp;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/3 0003
 * @description： 假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，
 * 从第二年开始，母牛开始生小母牛。
 * 每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 */
public class CowQuestion {
    public static void main(String[] args) {

    }

    private static int cowQuestion(int year) {
        int pre3 = 1;
        if (year == 1) {
            return pre3;
        }
        int pre2 = 2;
        if (year == 2) {
            return pre2;
        }
        int pre1 = 3;
        if (year == 3) {
            return pre1;
        }
        for (int i = 4; i <= year; i++) {
            int temp = pre1 + pre3;
            pre3 = pre2;
            pre2 = pre1;
            pre1 = temp;
        }
        return pre1;
    }
}
