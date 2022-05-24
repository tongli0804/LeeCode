package Leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dylan.ll
 * @date 2022/3/19 10:38
 */
public class NumberOfArithmeticSlices_413_等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int count=0;
        int preIndexCount=0;
        if(nums[2]-nums[1]==nums[1]-nums[0]){
            count++;
            preIndexCount++;
        }
        for (int i = 3; i < nums.length; i++) {
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                count+=preIndexCount;
                preIndexCount++;
                count++;
            }else {
                preIndexCount=0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4};
        System.out.println(new NumberOfArithmeticSlices_413_等差数列划分().numberOfArithmeticSlices(nums));
    }
}
