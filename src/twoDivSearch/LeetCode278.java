package twoDivSearch;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/25 0025
 * @description：
 */
public class LeetCode278 {
    public int firstBadVersion(int n) {
        int left = 1,right = n;
        while (left < right){
            int mid = left +(right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    public boolean isBadVersion(int version){
        return true;
    }
}
