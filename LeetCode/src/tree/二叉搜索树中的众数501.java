package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/31 0031
 * @description：
 */
public class 二叉搜索树中的众数501 {
    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        if (preNode != null) {
            if (preNode.val == root.val) {
                curCnt++;
            } else {
                curCnt = 1;
            }
        }
        preNode = root;
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            list.clear();
            list.add(root.val);
        } else if (curCnt == maxCnt) {
            list.add(root.val);
        }
        inOrder(root.right, list);
    }
}
