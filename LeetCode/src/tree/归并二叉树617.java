package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/27 0027
 * @description：
 */
public class 归并二叉树617 {
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
