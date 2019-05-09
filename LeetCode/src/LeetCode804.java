import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：summerGit
 * @date ：2019/5/7 0007
 * @description：
 */
public class LeetCode804 {
    private String[] strs = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "...."
            , "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-"
            , ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                sb.append(strs[c - 'a']);
            }
            String temp = sb.toString();
            if (!list.contains(temp)) {
                list.add(temp);
            }
        }
        return list.size();
    }

}
