package graph;

import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/18 0018
 * @description：
 */
public class 冗余连接684 {
    public static void main(String[] args) {
        int[][] edges = {{9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    /**
     * @author: lightingSummer
     * @date: 2019/7/18 0018
     * @description: 找树节点
     * @param edges
     * @return int[]
     */
    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t))
                return edge;
            else {
                parent[find(parent, f)] = find(parent, t);
            }
        }
        return new int[2];
    }

    private static int find(int[] parent, int f) {
        if (f != parent[f]) {
            parent[f] = find(parent, parent[f]);
        }
        return parent[f];
    }

}
