package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/5 20:44
 */
public class NumSubarrayProductLessThanK_713_乘积小于K的子数组 {
    /*public int numSubarrayProductLessThanK(int[] nums, int k) {
        int index = 0;
        int res = 0;
        int windowProduct=1;
        int windowSize = 0;
        while (index < nums.length) {
            int product = 1;
            windowSize = 0;
            do {
                product = product * nums[index + windowSize];
                if(product<k){
                    res++;
                }
                windowSize++;
            } while (product < k && index + windowSize<nums.length) ;
            index++;
        }
        return res;
    }
*/
    //优化方法
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int res = 0;
        int windowProduct=1;
        int right = 0;
        int left=0;
        for (; right < nums.length; right++) {
            windowProduct*=nums[right];
            while (windowProduct>=k && right>left){
                windowProduct/=nums[left];
                left++;
            }
            if(windowProduct<k){
                res+=(right-left)+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums={57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        int k=18;
        System.out.println(new NumSubarrayProductLessThanK_713_乘积小于K的子数组().numSubarrayProductLessThanK(nums,k));
    }
}
