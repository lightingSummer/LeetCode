/**
 * @author ：summerGit
 * @date ：2019/5/7 0007
 * @description：
 */
public class LeetCode461 {
    /**
     * author: summerGit
     * date: 2019/5/7 0007
     * description: The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     *
     * Given two integers x and y, calculate the Hamming distance.
     */
    public int hammingDistance(int x, int y) {
        int temp=x^y;
        int count=0;
        for(int i=0;i<32;i++){
            count+=(temp>>i)&1;
        }
        return count;
    }
}
