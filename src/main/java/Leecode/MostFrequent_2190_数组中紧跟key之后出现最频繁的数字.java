package Leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dylan.ll
 * @date 2022/3/21 22:46
 */
public class MostFrequent_2190_数组中紧跟key之后出现最频繁的数字 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer,Integer> countMap=new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==key){
                countMap.put(nums[i+1],countMap.getOrDefault(nums[i+1],0)+1);
            }
        }
        int maxCount=0;
        int nextNum=0;
        for (Map.Entry<Integer,Integer> entry:countMap.entrySet()){
            if(entry.getValue()>maxCount){
                maxCount=entry.getValue();
                nextNum=entry.getKey();
            }
        }
        return nextNum;
    }
}
