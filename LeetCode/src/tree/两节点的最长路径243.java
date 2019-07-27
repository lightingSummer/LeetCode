package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/27 0027
 * @description：
 */
public class 两节点的最长路径243 {
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        res = Math.max(leftDepth + rightDepth + 1, res);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
