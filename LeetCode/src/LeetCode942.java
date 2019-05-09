/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode942 {
    /**
     * author: summerGit
     * date: 2019/5/8 0008
     * description:Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
     * <p>
     * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
     * <p>
     * If S[i] == "I", then A[i] < A[i+1]
     * If S[i] == "D", then A[i] > A[i+1]
     */
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] result = new int[n + 1];
        int left = 0, right = n;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I') {
                result[i] = left++;
            } else {
                result[i] = right--;
            }
        }
        result[n] = left;
        return result;
    }
}
