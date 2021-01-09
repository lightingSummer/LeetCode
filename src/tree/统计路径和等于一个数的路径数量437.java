package tree;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/27 0027
 * @description：
 */
public class 统计路径和等于一个数的路径数量437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (sum == root.val) {
            res++;
        }
        res += pathSumStartWithRoot(root.left, sum - root.val)
                + pathSumStartWithRoot(root.right, sum - root.val);
        return res;
    }
}
