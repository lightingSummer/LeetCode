package Serach.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/11 0011
 * @description：
 */
public class 组成整数的最小平方数数量279 {
    public int numSquares(int n) {
        List<Integer> list = sequence(n);
        int length = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] flag = new boolean[n];
        queue.add(n);
        //求一个无向图从n到0的最短路径
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int num : list) {
                    int next = cur - num;
                    if (next < 0) {
                        break;
                    } else if (next == 0) {
                        return length;
                    }
                    if (flag[next]) {
                        continue;
                    }
                    flag[next] = true;
                    queue.offer(next);
                }
            }
        }
        return n;
    }

    private List<Integer> sequence(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        return list;
    }
}
