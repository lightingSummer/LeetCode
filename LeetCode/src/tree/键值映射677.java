package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/31 0031
 * @description：
 */
public class 键值映射677 {
    class MapSum {
        private class TrieNode {
            private int value = 0;
            private Map<Character, TrieNode> map = new HashMap<>();

            public TrieNode getSubNode(char c) {
                return map.get(c);
            }

            public void addSubNode(char c) {
                map.put(c, new TrieNode());
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public Map<Character, TrieNode> getMap() {
                return map;
            }
        }

        private TrieNode root = new TrieNode();

        /** Initialize your data structure here. */
        public MapSum() {

        }

        public void insert(String key, int val) {
            TrieNode temp = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (temp.getSubNode(c) == null) {
                    temp.addSubNode(c);
                }
                temp = temp.getSubNode(c);
                temp.setValue(val);
            }
        }

        public int sum(String prefix) {
            TrieNode temp = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (temp.getSubNode(c) == null) {
                    return 0;
                }
                temp = temp.getSubNode(c);
            }
            return computeSum(temp);
        }

        private int computeSum(TrieNode node) {
            int res = node.value;
            for (Map.Entry<Character, TrieNode> entry : node.getMap().entrySet()) {
                res += computeSum(entry.getValue());
            }
            return res;
        }
    }
}
