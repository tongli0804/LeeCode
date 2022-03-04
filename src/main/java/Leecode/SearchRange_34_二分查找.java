package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/2 22:19
 */
public class SearchRange_34_二分查找 {

    public int[] searchRange(int[] nums, int target) {

        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int start=findStart(nums,target);
        if(start==-1){
            return new int[]{-1,-1};
        }
        int end=findEnd(nums,target);

        return new int[]{start,end};
    }

    private int findStart(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while (start<end){
            int mid=(start+end) >> 1;
            if(nums[mid]<target){
                start=mid+1;
            }else if(nums[mid]==target){
                end=mid;
            }else {
                end=mid-1;
            }
        }
        if(nums[start]==target){
            return start;
        }

        return -1;
    }

    private int findEnd(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while (start<end){
            int mid=(start+end+1) >> 1;
            if(nums[mid]<target){
                start=mid+1;
            }else if(nums[mid]==target){
                start=mid;
            }else {
                end=mid-1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] res=new SearchRange_34_二分查找().searchRange(new int[]{5,7,7,8,8,10},6);
        System.out.println(res[0]+","+res[1]);
    }
}
