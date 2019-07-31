package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/31 0031
 * @description：
 */
public class 实现Trie前缀树208 {
    class Trie {
        private Map<Character, Trie> map;
        private boolean isEnd = false;

        /** Initialize your data structure here. */
        public Trie() {
            map = new HashMap<>();
        }

        private void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        private boolean isEnd() {
            return isEnd;
        }

        private Trie getSubNode(char c) {
            return map.get(c);
        }

        private void addSubNode(char c) {
            map.put(c, new Trie());
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (trie.getSubNode(c) == null) {
                    trie.addSubNode(c);
                }
                trie = trie.getSubNode(c);
            }
            trie.setEnd(true);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (trie.getSubNode(c) == null) {
                    return false;
                }
                trie = trie.getSubNode(c);
            }
            return trie.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return startsWith(this, prefix, 0);
        }

        private boolean startsWith(Trie trie, String prefix, int index) {
            if (index == prefix.length()) {
                return true;
            }
            if (trie.getSubNode(prefix.charAt(index)) != null) {
                return startsWith(trie.getSubNode(prefix.charAt(index)), prefix, index + 1);
            }
            return false;
        }
    }
}
