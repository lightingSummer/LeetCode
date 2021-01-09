package leetcode;

/**
 * @author     ：lightingSummer
 * @date       ：2019/5/29 0029
 * @description： Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 */
public class LeetCode034 {
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        if(nums==null)
            return res;
        int left=findNum(nums,target,1);
        if(left!=-1){
            res[0]=left;
            res[1]=findNum(nums,target,0);
        }
        return res;
    }
    public int findNum(int[] nums,int target,int needLeft){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target ){
                if(needLeft==1){
                    while (mid>=0 && nums[mid]==target ){
                        mid--;
                    }
                    return  mid==0 && nums[mid]==target?mid:mid+1;
                }else {
                    while ( mid<=right && nums[mid]==target ){
                        mid++;
                    }
                    return mid==right && nums[mid]==target?mid:mid-1;
                }
            }else if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }
}
