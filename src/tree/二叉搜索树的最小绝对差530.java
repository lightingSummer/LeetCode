package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/31 0031
 * @description：
 */
public class 二叉搜索树的最小绝对差530 {
    private static int min = Integer.MAX_VALUE;
    private static TreeNode pre = null;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        node1.right = node5;
        node5.left = node3;
        System.out.println(getMinimumDifference(node1));
    }

    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        getMinimumDifference(root.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(root.val - pre.val));
        }
        pre = root;
        getMinimumDifference(root.right);
        return min;
    }
}
