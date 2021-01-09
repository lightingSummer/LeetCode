package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description：
 */
public class LeetCode451 {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }
        List<Character>[] bucket = new ArrayList[s.length()+1];
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            if(bucket[value] == null){
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }
        StringBuffer sb = new StringBuffer();
        for(int i = bucket.length-1;i>0;i--){
            if(bucket[i]==null){
                continue;
            }
            for(int k=0;k<bucket[i].size();k++){
                for(int j=0;j<i;j++){
                    sb.append(bucket[i].get(k));
                }
            }
        }
        return sb.toString();
    }
}
