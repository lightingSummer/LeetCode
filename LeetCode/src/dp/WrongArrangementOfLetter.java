package dp;

import java.util.Scanner;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/1 0001
 * @description： 信件错排  n封信 所有人都收到错误的信的情况
 * 前i封信错误 i n-1种情况 1.k 放在n的位子D(n-2) 2. D(n-1)
 */
public class WrongArrangementOfLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long[] dp = new long[22];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 22; i++) {
            dp[i] = (i - 1) * dp[i - 1] + (i - 1) * dp[i - 2];
        }

        while (in.hasNext()){
            int num = in.nextInt();
            System.out.println(dp[num]);
        }

    }
}
