package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/18 23:16
 */
public class Jump_45_跳跃游戏2 {

    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int jumpCount=0;
        int stepMostValue=0;
        int stepEnd=0;

        for (int i = 0; i < nums.length-1; i++) {

            stepMostValue=Math.max(stepMostValue,nums[i]+i);
            if(i==stepEnd){
                jumpCount++;
                stepEnd=stepMostValue;
            }

        }
        return jumpCount;
    }


}
