package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/18 22:52
 */
public class Rob_213_打家劫舍2 {
    public int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        int max=dp[1];
        for (int i = 2; i < nums.length-1; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            max=Math.max(max,dp[i]);
        }
        dp[0]=0;
        dp[1]=nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={1,2,1,1};
        System.out.println(new Rob_213_打家劫舍2().rob(nums));
    }
}
