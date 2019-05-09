import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ：summerGit
 * @date ：2019/4/15 0015
 * @description：
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums={49,38,65,97,76,13,27,49};
        sort(nums);
    }
    public static void sort(int[] nums){
        for(int i=0;i<nums.length;i++) {
            int index=i;
            for (int j = i + 1;j<nums.length;j++){
                if(nums[j]<nums[index])
                    index=j;
            }
            swap(nums,index,i);
            System.out.println(Arrays.toString(nums));
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
