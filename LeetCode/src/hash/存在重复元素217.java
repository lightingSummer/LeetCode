package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author     ：lightingSummer
 * @date       ：2019/7/17 0017
 * @description：
 */
public class 存在重复元素217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
