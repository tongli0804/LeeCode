package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/4 22:17
 */
public class FindMin_153_寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        int start=0,end=nums.length-1;
        int last=nums[end];
        if(nums[0]<last){
            return nums[0];
        }
        while (start<end){
            int mid=(start+end) >> 1;
            if(nums[mid]>last){
                start=mid+1;
            }else if(nums[mid]<last){
                end=mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums={0,1,2,4,5,6,7};
        System.out.println(new FindMin_153_寻找旋转排序数组中的最小值().findMin(nums));
    }


}
