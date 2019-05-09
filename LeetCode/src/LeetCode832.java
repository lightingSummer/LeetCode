/**
 * @author ：summerGit
 * @date ：2019/5/7 0007
 * @description：
 */
public class LeetCode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int n=A.length;
        for(int[] row:A){
            for(int i=0;i*2<n;i++){
                if(row[i]==row[n-i-1]){
                    row[i]=row[n-i-1]^=1;
                }
            }
        }
        return A;
    }
}
