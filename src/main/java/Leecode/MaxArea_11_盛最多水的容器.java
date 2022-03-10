package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/8 23:06
 */
public class MaxArea_11_盛最多水的容器 {

    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while (left<right){
            maxArea=Math.max(maxArea,(right-left)*Math.min(height[left],height[right]));
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

}
