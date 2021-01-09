package graph;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/18 0018
 * @description：
 */
public class 判断是否是二分图 {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0 && !addColor(i, 1, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean addColor(int index, int color, int[] colors, int[][] graph) {
        if (colors[index] != 0) {
            return colors[index] == color;
        }
        colors[index] = color;
        for (int next : graph[index]) {
            if (!addColor(next, -color, colors, graph)) {
                return false;
            }
        }
        return true;
    }

}
