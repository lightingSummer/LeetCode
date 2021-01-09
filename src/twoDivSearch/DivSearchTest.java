package twoDivSearch;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/25 0025
 * @description：
 */
public class DivSearchTest {
    public static void main(String[] args) {
        int d = (int) (Math.random() * 100);
        System.out.println(d);
        int[] array = new int[99];
        for (int i = 0; i < 100; i++) {
            if (i < d) {
                array[i] = i;
            } else if (i > d) {
                array[i - 1] = i;
            }
        }
        System.out.println(findNum(array));

    }

    public static int findNum(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
