package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/5/7 0007
 * @description：
 */
public class LeetCode905 {
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++) {
            if ((A[j] & 1) == 0){
                int temp=A[i];
                A[i++]=A[j];
                A[j]=temp;
            }
        }
        return A;
    }
}
