package string;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/21 0021
 * @description：
 * s = "I am a student"
 * Return "student a am I"
 */
public class 字符串中单词的翻转 {
    public static void main(String[] args) {
        String d = "I am a student";
        System.out.println(revVocOfSentence(d));
    }
    public static String revVocOfSentence(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
