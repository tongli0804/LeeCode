package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/2 23:26
 */
public class Search_33_二分查找 {

    public int search(int[] nums, int target) {
        int k =searchK(nums);
        int index=searchTarget(nums,k,target);
        return index;
    }

    private int searchTarget(int[] nums, int k, int target) {
        int start=0,end=nums.length-1;
        if(nums[0]==target){
            return 0;
        }else if(nums[0]<target){
            start=1;
            end=k-1;
        }else {
            start=k;
        }
        if(start>end){
            return -1;
        }
        while (start<end){
            int mid=(start+end)>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        if(nums[start]==target){
            return start;
        }
        return -1;
    }

    private int searchK(int[] nums) {
        int start=0,end=nums.length-1;
        int last=nums[end];
        if(nums[0]<last){
            return nums.length;
        }
        while (start<end){
            int mid=(start+end) >> 1;
            if(nums[mid]>last){
                start=mid+1;
            }else if(nums[mid]<last){
                end=mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new Search_33_二分查找().search(new int[]{1,3},0));
    }
}
