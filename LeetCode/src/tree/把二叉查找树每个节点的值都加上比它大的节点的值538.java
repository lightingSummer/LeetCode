package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/30 0030
 * @description：
 */
public class 把二叉查找树每个节点的值都加上比它大的节点的值538 {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        int temp = root.val;
        root.val += sum;
        sum += temp;
        convertBST(root.left);
        return root;
    }
}
