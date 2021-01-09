package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/27 0027
 * @description：
 */
public class 最长同值路径687 {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rootValue = findPath(root.left, root.val) + findPath(root.right, root.val);
        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);
        return Math.max(Math.max(rootValue, left), right);
    }

    private int findPath(TreeNode root, int value) {
        if (root == null || root.val != value) {
            return 0;
        }
        return Math.max(findPath(root.left, value), findPath(root.right, value)) + 1;
    }
}
