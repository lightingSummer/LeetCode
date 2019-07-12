package serach.dfs;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/12 0012
 * @description： 好友关系可以看成一张无向图
 */
public class 好友关系的连通分量数目547 {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int m = M.length;
        int res = 0;
        boolean[] isVisited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (!isVisited[i]) {
                dfs(M, i, isVisited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int x, boolean[] isVisited) {
        isVisited[x] = true;
        for (int i = x; i < M.length; i++) {
            if (M[x][i] == 1) {
                dfs(M,i,isVisited);
            }
        }
    }
}
