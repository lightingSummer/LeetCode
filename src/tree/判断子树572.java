package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/27 0027
 * @description：
 */
public class 判断子树572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return judgeSubtree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean judgeSubtree(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (s != null && t != null) {
            if (s.val != t.val) {
                return false;
            }
            return judgeSubtree(s.left, t.left) && judgeSubtree(s.right, t.right);
        }
        return false;
    }
}
