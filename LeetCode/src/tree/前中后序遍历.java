package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/30 0030
 * @description：
 */
public class 前中后序遍历 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        layerOrder(node1);
        preOrder(node1);
        System.out.println();
        preOrder1(node1);
        System.out.println();
        inOrder(node1);

        System.out.println();
        System.out.println();
        System.out.println(寻找二叉查找树的第k个元素230.kthSmallest1(node1,3));
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    private static void preOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void layerOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cnt = 0;
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            cnt++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (cnt == size) {
                cnt = 0;
                size = queue.size();
                System.out.println();
            }
        }
    }
}
