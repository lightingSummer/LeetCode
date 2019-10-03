package string;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/22 0022
 * @description： 回文字符串：从字符串的某一位开始，尝试着去扩展子字符串。
 */
public class 回文子串647 {
    private int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);
            extendSubstrings(s, i, i + 1);
        }
        return count;
    }

    private void extendSubstrings(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    public int countSubstrings1(String s){
        Callable<Integer> callable1 = new Callable<Integer>() {
            int cnt = 0;

            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < s.length(); i++) {
                    cnt = extendSubstrings1(s, i, i, cnt);
                }
                return cnt;
            }
        };
        FutureTask<Integer> task1 = new FutureTask<>(callable1);
        new Thread(task1).start();
        Callable<Integer> callable2 = new Callable<Integer>() {
            int cnt = 0;

            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < s.length(); i++) {
                    cnt = extendSubstrings1(s, i, i + 1, cnt);
                }
                return cnt;
            }
        };
        FutureTask<Integer> task2 = new FutureTask<>(callable2);
        new Thread(task2).start();
        int val1 = 0;
        int val2 = 0;
        try {
            val1 = task1.get();
            val2 = task2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return val1 + val2;
    }

    private int extendSubstrings1(String s, int left, int right, int cnt) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
