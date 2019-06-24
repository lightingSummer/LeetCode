package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/22 0022
 * @description：
 */
public class LeetCode215 {
    /**
     * @author: lightingSummer
     * @date: 2019/6/24 0024
     * @description: 小顶堆
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : nums) {
            queue.offer(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        findKthLargest2(nums, 2);
        System.out.println(Arrays.toString(nums));
        partitionSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * @author: lightingSummer
     * @date: 2019/6/24 0024
     * @description: 快排分割
     */
    public static int findKthLargest2(int[] nums, int k) {

        if (nums == null || k > nums.length) {
            return -1;
        }
        int target = nums.length - k;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int flag = partition(nums, start, end);
            if (flag < target) {
                start = flag + 1;
            } else if (flag > target) {
                end = flag - 1;
            } else {
                break;
            }
        }
        return nums[target];
    }

    private static int partition(int[] a, int l, int h) {
        int i = l, j = h;
        int num = a[i];
        while (i < j) {
            while (i<j && a[j]>=num){
                j--;
            }
            while (i<j && a[i]<=num){
                i++;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[l] = a[i];
        a[i] = num;
        return i;

    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void partitionSort(int[] a, int low, int high) {
        if (low >= high)
            return;
        int p = quickSort(a, low, high);
        partitionSort(a, low, p - 1);
        partitionSort(a, p + 1, high);
    }

    public static int quickSort(int[] a, int low, int high) {
        int i = low, j = high;
        int num = a[low];
        while (i < j) {
            while (i < j && a[j] <= num) {
                j--;
            }
            while (i < j && a[i] >= num) {
                i++;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[low] = a[i];
        a[i] = num;
        return i;
    }
}
