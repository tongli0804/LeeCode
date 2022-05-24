package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author dylan.ll
 * @date 2022/3/12 23:05
 */
public class CombinationSum_39_组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> isSelected=new ArrayList<>();

        dfs(candidates,target,0,isSelected,res);

        //去重
        res.forEach(list -> list.sort(Comparator.naturalOrder()));

        Set<List<Integer>> set=new HashSet<>(res);

        return new ArrayList<>(set);
    }

    private void dfs(int[] candidates, int target,int index,List<Integer> isSelected,List<List<Integer>> res){
        if(index==candidates.length|| target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(isSelected));
        }
    //   两种情况，当前index 位置的数据是否选择，如果不选择
        dfs(candidates,target,index+1,isSelected,res);

    //    如果选择，下一个也从index 开始，因为可以重复选择这个数字
        if(target-candidates[index]>=0){
            isSelected.add(candidates[index]);

            dfs(candidates,target-candidates[index],index,isSelected,res);

            //往前回溯一个位置
            isSelected.remove(isSelected.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates=new int[]{2,3,6,7};
        int target=7;
        System.out.println(JSON.toJSONString(new CombinationSum_39_组合总和().combinationSum(candidates,target)));

    }
}
