package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/30 0030
 * @description：
 */
public class 二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        int cnt = 0;
        double sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sum += node.val;
            cnt++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (cnt == size) {
                size = queue.size();
                sum /= cnt;
                res.add(sum);
                sum = 0;
                cnt = 0;
            }
        }
        return res;
    }
}
