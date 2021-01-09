package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/18 0018
 * @description：
 */
public class 课程安排的合法性207 {

    /**
     * @author: lightingSummer
     * @date: 2019/7/18 0018
     * @description: list
     * @param numCourses
     * @param prerequisites
     * @return boolean
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<Integer>[] nexts = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nexts[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            nexts[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] globalMarked = new boolean[numCourses];
        boolean[] localMarked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCyclic(i, nexts, globalMarked, localMarked)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCyclic(int start, List<Integer>[] nexts, boolean[] globalMarked, boolean[] localMarked) {
        if (localMarked[start]) {
            return true;
        }
        if (globalMarked[start]) {
            return false;
        }
        globalMarked[start] = true;
        localMarked[start] = true;
        for (int next : nexts[start]) {
            if (hasCyclic(next, nexts, globalMarked, localMarked)) {
                return true;
            }
        }
        localMarked[start] = false;
        return false;
    }


    /**
     * @author: lightingSummer
     * @date: 2019/7/18 0018
     * @description: map
     * @param numCourses
     * @param prerequisites
     * @return boolean
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int length = (int) (numCourses / 0.75) + 1;
        Map<Integer, List<Integer>> map = new HashMap<>(length);
        // 构造有向图
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][0];
            int now = prerequisites[i][1];
            if (!map.containsKey(pre)) {
                map.put(pre, new ArrayList<>());
            }
            map.get(pre).add(now);
        }
        boolean[] hasVisited = new boolean[numCourses];
        boolean[] globalVisited = new boolean[numCourses];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (isCyclic(map, entry.getKey(), hasVisited, globalVisited)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclic(Map<Integer, List<Integer>> map, int start, boolean[] hasVisited, boolean[] globalVisited) {
        if (hasVisited[start]) {
            return true;
        }
        if (globalVisited[start]) {
            return false;
        }
        if (map.containsKey(start)) {
            hasVisited[start] = true;
            globalVisited[start] = true;
            for (int next : map.get(start)) {
                if (isCyclic(map, next, hasVisited, globalVisited)) {
                    return true;
                }
            }
            hasVisited[start] = false;
        }
        return false;
    }
}
