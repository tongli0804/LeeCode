package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/4 22:46
 */
public class FindPeakElement_162_寻找峰值 {

    public int findPeakElement(int[] nums) {
        int start=0,end=nums.length-1;
        while (start<end){
            int mid=(start+end) >> 1;
            if(nums[mid]<nums[mid+1]){
                start=mid+1;
            }else {
                end=mid;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,1};
        System.out.println(new FindPeakElement_162_寻找峰值().findPeakElement(nums));
    }
}
