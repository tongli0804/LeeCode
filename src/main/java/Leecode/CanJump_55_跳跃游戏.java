package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/18 23:16
 */
public class CanJump_55_跳跃游戏 {

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int dp=nums[0];
        for (int i = 1; i < nums.length; i++) {

            if(dp==0){
                return false;
            }
            dp=Math.max(dp-1,nums[i]);
        }
        return true;
    }
}
