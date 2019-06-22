package leetcode;//通过Map 类实现，通过键值对的方式，可以将输入的字符串的每一个字符，作为键，每个字符出现的次数作为值：如下：

import java.util.*;

public class LeetCodeNC5 {
    public static void main(String[] args) {
        String scan = new Scanner(System.in).nextLine();//获取键盘上输入的字符串；
        Map<Character, Integer> map = new HashMap<Character, Integer>();//新建一个HashMap对象；　　　　
        //通过FOR循环，把String的键值存放到map
        for (int i = 0; i < scan.length(); i++) {
            char temp = scan.charAt(i);//通过循环，找到字符串的每一位字符并存入到temp中；
            if (map.containsKey(temp)) {//如果map里面有temp这个字符
                map.put(temp, map.get(temp) + 1);//把temp的值加1；
            } else {//如果map里面没有temp这个字符，
                map.put(temp, 1);//把temp的值设为1；
            }
        }
        int maxnum = Collections.max(map.values());//调用Collections类的max方法，获取map的值的集合；并找出最大的那个值；
        Set<Character> set = new HashSet<Character>();//建立一个set对象
        for (Map.Entry<Character, Integer> entry1 : map.entrySet()) { //通过集合的循环，把map的值放到entry1里，通过entry1找到值最大的maxnum的key;
            if (entry1.getValue() == maxnum) {
                set.add(entry1.getKey());
            }
        }
        System.out.println("出现次数最多的字母为：" + set + " 最多出现次数为" + maxnum);

    }

}