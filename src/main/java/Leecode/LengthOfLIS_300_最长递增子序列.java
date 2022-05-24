package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/19 11:32
 */
public class LengthOfLIS_300_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {

        //保存以i 结尾的最长上升子序列大小
        int[] dp = new int[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 2, 3};
        System.out.println(new LengthOfLIS_300_最长递增子序列().lengthOfLIS(nums));
    }

}
