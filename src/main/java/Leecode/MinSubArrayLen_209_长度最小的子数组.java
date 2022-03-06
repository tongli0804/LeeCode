package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/5 22:29
 */
public class MinSubArrayLen_209_长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];

            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int target = 11;
        int nums[] = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(new MinSubArrayLen_209_长度最小的子数组().minSubArrayLen(target, nums));
    }
}
