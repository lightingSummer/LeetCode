package leetcode;

public class LeetCodeNC4 {
    private static int minPath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] grid={{1,3},{2,4}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        findMinPath(grid, 0, 0, grid.length, grid[0].length, 0);
        return minPath;
    }

    public static void findMinPath(int[][] grid, int row, int col, int down, int right, int path) {
        if (row >= down || col >= right)
            return;
        path += grid[row][col];
        if (row == down - 1 && col == right - 1) {
            if (path < minPath)
                minPath = path;
        }
        findMinPath(grid, row + 1, col, down, right, path);
        findMinPath(grid, row, col + 1, down, right, path);
    }
}