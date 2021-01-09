package leetcode;

/**
 * @author ：summerGit
 * @date ：2019/5/7 0007
 * @description：
 */
public class LeetCode977 {
    /**
     * author: summerGit
     * date: 2019/5/7 0007
     * description: Given an array of integers A sorted in non-decreasing order,
     * return an array of the squares of each number, also in sorted non-decreasing order.
     */
    public int[] sortedSquares(int[] A) {
        int len=A.length;
        int[] result=new int[len];
        for(int p=len-1,i=0,j=len-1;p>=0;p--){
            if(Math.abs(A[i])<Math.abs(A[j])){
                result[p]=A[j]*A[j];
                j--;
            }
            else {
                result[p]=A[i]*A[i];
                i++;
            }
        }
        return result;
    }
}
