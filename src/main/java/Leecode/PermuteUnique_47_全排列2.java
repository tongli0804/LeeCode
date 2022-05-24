package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dylan.ll
 * @date 2022/3/11 23:12
 */
public class PermuteUnique_47_全排列2 {
    public static Set<String> listStr = new HashSet<>();
    public static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        res.add(first);
        for (int i = 1; i < nums.length; i++) {
            int size = res.size();

            for (int j = 0; j < size; j++) {
                List<Integer> preSub = res.get(j);
                for (int k = 0; k < preSub.size(); k++) {
                    if (nums[i] != preSub.get(k)) {
                        List<Integer> next = new ArrayList<>(preSub);
                        next.add(k, nums[i]);
                        res.add(next);
                    }
                }
                preSub.add(nums[i]);
            }

        }

        res=res.stream().filter(this::isNotExist).collect(Collectors.toList());

        return res;
    }

    private boolean isNotExist(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer cur : list) {
            stringBuilder.append(cur).append(",");
        }
        return listStr.add(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new PermuteUnique_47_全排列2().permuteUnique(new int[] {1,2,3})));
    }
}
