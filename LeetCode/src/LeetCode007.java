/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode007 {
    /**
     * author: summerGit
     * date: 2019/5/8 0008
     * description: Given a 32-bit signed integer, reverse digits of an integer.
     */
    public static int reverse(int x) {
        int temp=Math.abs(x);
        int res=0;
        while (temp!=0){
            int tail=temp%10;
            int resTemp=10*res+tail;
            if((resTemp-tail)/10!=res){
                return 0;
            }
            res=resTemp;
            temp=temp/10;
        }
        return x>0?res:res*(-1);
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
