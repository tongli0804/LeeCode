package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author dylan.ll
 * @date 2022/3/11 22:11
 */
public class Subsets_78_子集2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        //记录这个数之前存在的数量
        int[] count=new int[nums.length];
        count[0]=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                count[i]=count[i-1]+1;
            }else {
                count[i]=0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int size=res.size();

            for (int j = 0; j < size; j++) {
                List<Integer> preSub=res.get(j);
                //最大的小于当前，则表示子集中不存在这个数 nums[i]

                if(count[i]==0 || count[i]==getCount(preSub,nums[i])){
                    List<Integer> nextSubset=new ArrayList<>(res.get(j));
                    nextSubset.add(nums[i]);
                    res.add(nextSubset);
                }
                else {
                //    ignore
                }

            }
            if(count[i]==0){
                res.add(Arrays.asList(nums[i]));
            }
        }
        //加上空集
        res.add(new ArrayList<>());

        return res;
    }

    private int getCount(List<Integer> list,int target){
        int count=0;
        for (int i = list.size()-1; i >= 0; i--) {
            if(list.get(i)==target){
                count++;
            }else {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Subsets_78_子集2().subsets(new int[]{1,2,2,2})));
    }

}
