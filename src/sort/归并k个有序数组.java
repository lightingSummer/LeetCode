package sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/17 0017
 * @description：
 */
public class 归并k个有序数组 {
    public static void main(String[] args) {
        List<int[]> arrays = Arrays.asList(new int[]{1, 2, 3}, new int[]{2, 3, 4}, new int[]{5, 9, 11});
        System.out.println(Arrays.toString(mergeKArrays(arrays)));
    }

    public static int[] mergeKArrays(List<int[]> arrays) {
        return partition(arrays, 0, arrays.size() - 1);
    }

    private static int[] partition(List<int[]> arrays, int left, int right) {
        if (left == right) {
            return arrays.get(left);
        }
        int mid = left + (right - left) / 2;
        int[] array1 = partition(arrays, left, mid);
        int[] array2 = partition(arrays, mid + 1, right);
        return merge(array1, array2);
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] res = new int[array1.length + array2.length];
        int i = 0, j = 0, t = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                res[t++] = array1[i++];
            } else {
                res[t++] = array1[j++];
            }
        }
        while (i < array1.length) {
            res[t++] = array1[i++];
        }
        while (j < array2.length) {
            res[t++] = array2[j++];
        }
        return res;
    }

}
