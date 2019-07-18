package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/18 0018
 * @description： 拓扑排序 由一些偏序得到全序
 */
public class 课程安排的顺序210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] localMarked = new boolean[numCourses];
        boolean[] globalMarked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCyclic(stack, i, graph, localMarked, globalMarked)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean hasCyclic(Stack<Integer> stack, int start, List<Integer>[] graph, boolean[] localMarked, boolean[] globalMarked) {
        if (localMarked[start]) {
            return true;
        }
        if (globalMarked[start]) {
            return false;
        }
        localMarked[start] = true;
        globalMarked[start] = true;
        for (int next : graph[start]) {
            if (hasCyclic(stack, next, graph, localMarked, globalMarked)) {
                return true;
            }
        }
        localMarked[start] = false;
        stack.push(start);
        return false;
    }
}
