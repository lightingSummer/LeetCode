package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/31 0031
 * @description：
 */
public class BST两数之和 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int temp1 = list.get(left);
            int temp2 = list.get(right);
            if (temp1 + temp2 == k) {
                return true;
            } else if (temp1 + temp2 < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
