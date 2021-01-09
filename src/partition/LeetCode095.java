package partition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/26 0026
 * @description：  不同的二叉搜索树  也是分治原理
 */
public class LeetCode095 {
    Map<String,List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return makeTree(1, n);
    }

    private List<TreeNode> makeTree(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        if(map.containsKey(s+"_"+e)){
            return map.get(s+"_"+e);
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> left = makeTree(s, i - 1);
            List<TreeNode> right = makeTree(i + 1, e);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        map.put(s+"_"+e,res);
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
