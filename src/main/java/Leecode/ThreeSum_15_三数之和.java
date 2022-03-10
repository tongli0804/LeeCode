package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dylan.ll
 * @date 2022/3/9 20:35
 */
public class ThreeSum_15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ) {

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(createList(nums[i], nums[left], nums[right]));

                    do {
                        left++;
                    }
                    while (nums[left] == nums[left - 1] && left < right);

                    do {
                        right--;
                    }
                    while (nums[right] == nums[right + 1] && left < right);

                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }

            do {
                i++;
            }
            while (nums[i]==nums[i-1] && i < nums.length - 2);
        }


        return res;
    }

    private List<Integer> createList(int first, int second, int third) {
        List<Integer> res = new ArrayList<>();
        res.add(first);
        res.add(second);
        res.add(third);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new ThreeSum_15_三数之和().threeSum(new int[] {-1, 0, 1, 2, -1, -4})));
    }
}