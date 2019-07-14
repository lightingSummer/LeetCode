package serach.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/13 0013
 * @description：
 */
public class 输出二叉树中所有从根到叶子的路径257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        dfs(root, res, sb);
        return res;
    }

    private void dfs(TreeNode root, List<String> res, StringBuffer sb) {
        if (root.left == null && root.right == null) {
            String part = sb.length() == 0 ? root.val + "" : "->" + root.val;
            sb.append(part);
            res.add(sb.toString());
            sb.delete(sb.length() - part.length(), sb.length());
            return;
        }
        String part = sb.length() == 0 ? root.val + "" : "->" + root.val;
        sb.append(part);
        if (root.left != null) {
            dfs(root.left, res, sb);
        }
        if (root.right != null) {
            dfs(root.right, res, sb);
        }
        sb.delete(sb.length() - part.length(), sb.length());
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
