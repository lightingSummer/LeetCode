package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description：
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class LeetCode406 {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length==0 || people[0].length==0){
            return people;
        }
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        List<int[]> list = new ArrayList<>();
        for(int[] p : people){
            list.add(p[1],p);
        }
        return list.toArray(new int[people.length][people[0].length]);
    }
}
