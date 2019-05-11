import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：summerGit
 * @date ：2019/5/11 0011
 * @description：
 */
public class LeetCode015 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
            while (left < right) {
                if(nums[left]+nums[right]==sum){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while (left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[left]+nums[right]<sum){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
    /**
     * author: summerGit
     * date: 2019/5/11 0011
     * description: 没有去重
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, temp, nums, 0, 0);
        return result;
    }

    public static void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int index, int sum) {
        if (sum == 0 && temp.size() == 3) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (index >= nums.length || temp.size() >= 3) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            sum += nums[i];
            dfs(result, temp, nums, i + 1, sum);
            sum -= nums[i];
            temp.remove(temp.size() - 1);
        }
    }
}
