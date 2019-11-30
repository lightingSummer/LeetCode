package likedQuestions;

/**
 * @author light
 * @date 30/11/2019 下午 3:38
 */
public class 幂函数050 {
    public double myPow(double x, int n) {
        long m = n > 0 ? n : -(long) n;
        double ans = 1.0;
        while (m != 0) {
            if ((m & 1) == 1)
                ans *= x;
            x *= x;
            m >>= 1;
        }
        return n >= 0 ? ans : 1 / ans;
    }
}
