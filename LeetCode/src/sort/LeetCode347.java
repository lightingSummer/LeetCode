package sort;

import java.util.*;

/**
 * @author     ：lightingSummer
 * @date       ：2019/6/24 0024
 * @description：  top-K frequent nums 桶排序
 */
public class LeetCode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
            map.put(num,map.get(num)+1);
        }

        List<Integer>[] bucket=new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(bucket[value]==null){
                bucket[value]=new ArrayList<>();
            }
            bucket[value].add(key);
        }

        //从桶里取 前k个
        List<Integer> topK=new ArrayList<>();
        for(int i = bucket.length-1;i>0 && topK.size()<k;i--){
            if(bucket[i]==null){
                continue;
            }
            if(bucket[i].size()<=k-topK.size()){
                topK.addAll(bucket[i]);
            }else {
                topK.addAll(bucket[i].subList(0,k-topK.size()));
            }
        }
        return topK;
    }
}
