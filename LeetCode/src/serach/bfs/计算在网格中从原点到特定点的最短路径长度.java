package serach.bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/11 0011
 * @description： bfs
 */
public class 计算在网格中从原点到特定点的最短路径长度 {
    public static void main(String[] args) {
        int[][] grids = {{1, 1, 0, 1}, {1, 0, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(minPathLength(grids, 0, 3));
        int[][] grids1 = {{1, 1, 0, 1}, {1, 0, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(minPathLength(grids1, 3, 3));
    }

    public static int minPathLength(int[][] grids, int tr, int tc) {
        final int[][] dic = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int xLen = grids[0].length;
        int yLen = grids.length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, 0));
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                Pair<Integer, Integer> pair = queue.poll();
                int trTemp = pair.getKey();
                int tcTemp = pair.getValue();
                grids[trTemp][tcTemp] = 0;
                for (int[] d : dic) {
                    int x = trTemp + d[0];
                    int y = tcTemp + d[1];
                    if (x >= 0 && x < xLen && y >= 0 && y < yLen && grids[x][y] != 0) {
                        if (tr == x && tc == y) {
                            return length;
                        }
                        queue.offer(new Pair<>(x, y));
                    }
                }
            }
        }
        return -1;
    }
}
