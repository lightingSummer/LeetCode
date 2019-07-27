package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/27 0027
 * @description：
 */
public class 平衡树110 {
    public boolean isBalanced(TreeNode root) {
        int res = getHeight(root);
        return res != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHigh = getHeight(root.left);
        if (leftHigh == -1) {
            return -1;
        }
        int rightHigh = getHeight(root.right);
        if (rightHigh == -1) {
            return -1;
        }
        if (Math.abs(leftHigh - rightHigh) > 1) {
            return -1;
        }
        return Math.max(leftHigh, rightHigh) + 1;
    }
}
