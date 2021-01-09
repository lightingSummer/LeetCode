package string;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description： 给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
 *
 * s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
 */
public class 字符串循环移位包含 {
    public boolean rolContain(String a, String b) {
        String temp = a + a;
        return temp.contains(b);
    }
}
