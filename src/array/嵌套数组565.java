package array;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/26 0026
 * @description： 这是由一个个小环组成的 重复环无须count 别的也不会进入你的环!!!
 */
public class 嵌套数组565 {
    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

    public static int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int temp = nums[j];
                nums[j] = -1;
                j = temp;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
