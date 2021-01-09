package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode617 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * author: summerGit
     * date: 2019/5/8 0008
     * description: Given two binary trees and imagine that when you put one of them to cover the other,
     * some nodes of the two trees are overlapped while the others are not.
     * <p>
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
     * then sum node values up as the new value of the merged node.
     * Otherwise, the NOT null node will be used as the node of new tree.
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode node;
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 != null) {
            node = new TreeNode(t1.val + t2.val);
        } else {
            node = new TreeNode(t1 == null ? t2.val : t1.val);
        }
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }
}
