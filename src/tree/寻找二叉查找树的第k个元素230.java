package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/30 0030
 * @description：
 */
public class 寻找二叉查找树的第k个元素230 {
    private int cnt = 1;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        int left = kthSmallest(root.left, k);
        if (left != -1) {
            return left;
        }
        if (cnt == k) {
            return root.val;
        }
        cnt++;
        int right = kthSmallest(root.right, k);
        if (right != -1) {
            return right;
        }
        return -1;
    }

    private static int number = 0;
    private static int count = 0;

    public static int kthSmallest1(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public static void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
}
