package twoPointer;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/22 0022
 * @description：
 */
public class LeetCode088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur=nums1.length-1;
        m--;
        n--;
        while (m>=0 && n>=0){
            if(nums1[m]>nums2[n]){
                nums1[cur--]=nums1[m--];
            }else {
                nums1[cur--]=nums2[n--];
            }
        }
        while (m>=0){
            nums1[cur--]=nums1[m--];
        }
        while (n>=0){
            nums1[cur--]=nums2[n--];
        }
    }
}
