package serach.bfs;

import java.util.*;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/11 0011
 * @description：
 */
public class 单词接龙127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Map<String, Boolean> map = new HashMap<>();
        for (String str : wordList) {
            map.put(str, false);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                String str = queue.poll();
                if (isConnect(str, endWord)) {
                    return length+1;
                }
                for (String s : wordList) {
                    if (!map.get(s) && isConnect(str, s)) {
                        queue.offer(s);
                        map.put(s, true);
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isConnect(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length() && diff <= 1; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
