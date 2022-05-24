package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/19 11:32
 */
public class FindNumberOfLIS_673_最长递增子序列的个数 {

    public int findNumberOfLIS(int[] nums) {

        //保存以i 结尾的最长上升子序列大小
        int[] dp = new int[nums.length];
        int[] countDp=new int[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            countDp[i]=1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if(dp[i]<dp[j] + 1){
                        countDp[i]=countDp[j];
                        dp[i] = dp[j] + 1;
                    }else if(dp[i]==dp[j] + 1){
                        countDp[i]+=countDp[j];
                    }
                }
            }

            if(dp[i]>max){
                max=dp[i];
            }

        }
        int count=0;
        for (int i = 0; i < dp.length; i++) {
            if(max==dp[i]){
                count+=countDp[i];
            }
        }



        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,4,7};
        System.out.println(new FindNumberOfLIS_673_最长递增子序列的个数().findNumberOfLIS(nums));
    }

}
