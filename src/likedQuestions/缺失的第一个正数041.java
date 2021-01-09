package likedQuestions;

/**
 * @author     ：lightingSummer
 * @date       ：2019/9/9 0009
 * @description：
 */
public class 缺失的第一个正数041 {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    public static int firstMissingPositive(int[] A) {
        int index = 0;
        while (index < A.length) {
            if (A[index] >= 1 && A[index] <= A.length && A[A[index] - 1] != A[index]) {
                swap(A, index, A[index] - 1);
            } else {
                index++;
            }
        }
        int i = 0;
        while (i < A.length && i + 1 == A[i]) {
            i++;
        }
        return i + 1;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
