package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dylan.ll
 * @date 2022/3/9 20:35
 */
public class TwoSum_1_两数之和 {
    public int[] twoSum(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;
        Node[] nodes=new Node[nums.length];

        for (int i = 0; i <= right; i++) {
            nodes[i]=new Node(nums[i],i);
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o.value));

        while (left<right){
            if(nodes[left].value+nodes[right].value==target){
                return new int[]{nodes[left].index,nodes[right].index};
            }
            else if(nodes[left].value+nodes[right].value>target){
                right--;
            }
            else {
                left++;
            }
        }
        return new int[]{};

    }

   static class Node{
        int value;
        int index;

       public Node(int value, int index) {
           this.value = value;
           this.index = index;
       }
   }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new TwoSum_1_两数之和().twoSum(new int[]{3,2,4},6)));
    }
}