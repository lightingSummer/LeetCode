package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/30 0030
 * @description：
 */
public class 二叉查找树的最近公共祖先235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
