import java.util.HashSet;
import java.util.Set;

/**
 * @author ：summerGit
 * @date ：2019/5/7 0007
 * @description：u
 */
public class LeetCode961 {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<A.length;i++){
            if(!set.add(A[i])){
                return A[i];
            }
        }
        return A[0];
    }
}
