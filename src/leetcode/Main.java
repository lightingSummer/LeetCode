package leetcode;

import java.util.Stack;

public class Main {
    /**
     * author: summerGit
     * date: 2019/4/14 0014
     * description:参考博客，讲的真心好 http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
     */
    public static void main(String[] args) {
        char[][] matrix={{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},
                {'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] hight = new int[col + 1];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            //求每一行的高度，转化为直方图求面积
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1')
                    hight[j]++;
                else
                    hight[j] = 0;
            }
            //求直方图的面积
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            while (index < hight.length) {
                if (stack.isEmpty() || hight[stack.peek()] <= hight[index])
                    stack.push(index++);
                else {
                    int high = stack.pop();
                    maxArea = Math.max(maxArea, hight[high] * (stack.isEmpty() ? index : index - stack.peek() - 1));
                }
            }
        }
        return maxArea;
    }
}
