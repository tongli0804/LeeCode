package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dylan.ll
 * @date 2022/3/11 22:11
 */
public class Subsets_78_子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int count=res.size();

            for (int j = 0; j < count; j++) {
                List<Integer> nextSubset=new ArrayList<>(res.get(j));
                nextSubset.add(nums[i]);
                res.add(nextSubset);
            }
            res.add(Arrays.asList(nums[i]));
        }
        //加上空集
        res.add(new ArrayList<>());

        return res;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Subsets_78_子集().subsets(new int[]{0})));
    }

}
