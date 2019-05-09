/**
 * @author ：summerGit
 * @date ：2019/4/16 0016
 * @description：
 */
public class LeetCodeNC3 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(searchMatrix(matrix,4));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length,col=matrix[0].length;
        int low=0,high=row-1;
        while(low<=high){
            int midRow=(low+high)>>1;
            if(target<matrix[midRow][0])
                high=midRow-1;
            else if(target>matrix[midRow][col-1])
                low=midRow+1;
            else{
                int left=0,right=col-1;
                while(left<=right){
                    int midCol=(left+right)>>1;
                    if(matrix[midRow][midCol]==target)
                        return true;
                    else if(matrix[midRow][midCol]<target)
                        left=midCol+1;
                    else
                        right=midCol-1;
                }
            }
        }
        return false;
    }
}
