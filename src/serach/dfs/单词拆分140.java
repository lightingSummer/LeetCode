package serach.dfs;

import java.util.*;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/16 0016
 * @description：
 */
public class 单词拆分140 {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }

    private static Map<String, String> map = new HashMap<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        dfs(res, wordDict, s, new StringBuilder());
        return res;
    }

    private static void dfs(List<String> res, List<String> wordDict, String s, StringBuilder sb) {
        if (s.length() == 0) {
            res.add(sb.toString());
            return;
        }
        //if()

        for (String str : wordDict) {
            if (s.startsWith(str)) {
                String part = str;
                if (sb.length() != 0) {
                    str = " " + str;
                }
                sb.append(str);
                dfs(res, wordDict, s.substring(part.length()), sb);
                sb.delete(sb.length() - str.length(), sb.length());
            }
        }
        /*
        for (int i = 1; i <= s.length(); i++) {
            String part = s.substring(0, i);
            if (wordDict.contains(part)) {
                if (sb.length() != 0) {
                    part = " " + part;
                }
                sb.append(part);
                dfs(res, wordDict, s.substring(i, s.length()), sb);
                sb.delete(sb.length() - part.length(), sb.length());
            }
        }*/
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    private List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
