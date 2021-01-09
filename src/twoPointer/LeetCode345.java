package twoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/22 0022
 * @description：
 */
public class LeetCode345 {
    private static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        int left=0,right=chars.length-1;
        while (left<right){
            while (left<right && !set.contains(chars[right])){
                right--;
            }
            while (left<right && !set.contains(chars[left])){
                left++;
            }
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            right--;
            left++;
        }
        return String.valueOf(chars);
    }
}
