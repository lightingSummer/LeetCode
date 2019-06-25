package twoDivSearch;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/25 0025
 * @description：
 */
public class LeetCode065 {
    public static void main(String[] args) {
        System.out.println(mySqrt(144));
    }
    public static int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sqrt = x/mid;
            if(mid ==sqrt){
                return mid;
            }else if(mid < sqrt){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return right;
    }
}
