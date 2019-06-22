package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/5/4 0004
 * @description：
 */
public class LeetCode938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null ){
            return 0;
        }
        int temp=rangeSumBST(root.left,L,R);
        temp+=root.val;
        temp+=rangeSumBST(root.right, L, R);
        return temp;
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


