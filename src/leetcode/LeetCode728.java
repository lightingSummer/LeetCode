package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：summerGit
 * @date ：2019/5/8 0008
 * @description：
 */
public class LeetCode728 {
    /**
     * author: summerGit
     * date: 2019/5/8 0008
     * description: A self-dividing number is a number that is divisible by every digit it contains.
     * <p>
     * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
     * <p>
     * Also, a self-dividing number is not allowed to contain the digit zero.
     * <p>
     * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            int temp=i;
            while (temp!=0){
                int a=temp%10;
                if(a==0 || i%a!=0){
                    break;
                }
                temp=temp/10;
            }
            if(temp==0){
                list.add(i);
            }
        }
        return list;
    }
}
