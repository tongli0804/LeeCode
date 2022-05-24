package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author dylan.ll
 * @date 2022/3/12 23:05
 */
public class CombinationSum_40_组合总和2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> isSelected=new ArrayList<>();

        Arrays.sort(candidates);
        Map<Integer,Integer> countMap=new HashMap<>();
        Arrays.stream(candidates).forEach(cur-> countMap.put(cur,countMap.computeIfAbsent(cur,(key)->0)+1));

        dfs(candidates,target,0,isSelected,res,countMap);

        //去重
        res.forEach(list -> list.sort(Comparator.naturalOrder()));

        Set<List<Integer>> set=new HashSet<>(res);

        return new ArrayList<>(set);
    }
    private void dfs(int[] candidates, int target,int index,List<Integer> isSelected,List<List<Integer>> res,Map<Integer,Integer> countMap){

        if(target==0){
            res.add(new ArrayList<>(isSelected));
        }
        if(index==candidates.length || target<0){
            return;
        }
    //   当前index 的数字，结果选择多少个
        int count=countMap.get(candidates[index]);

        //不选择
        dfs(candidates,target,index+count,isSelected,res,countMap);

        //选择i 个
        for (int i = 1; i <= count; i++) {

            //添加 i 个
            for (int j = 0; j <i; j++) {
                isSelected.add(candidates[index]);
            }

            dfs(candidates, target - candidates[index]*i, index + count, isSelected, res, countMap);

            //往前回溯i个位置
            for (int j = 0; j <i; j++) {
                isSelected.remove(isSelected.size() - 1);
            }

        }

    }

    //直接递归回溯会超时，因为不重复，对于同样的数字，则可以用选择的数量来去重，直接得到不重复的解
    //public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //    List<List<Integer>> res=new ArrayList<>();
    //    List<Integer> isSelected=new ArrayList<>();
    //
    //    dfs(candidates,target,0,isSelected,res);
    //
    //    //去重
    //    res.forEach(list -> list.sort(Comparator.naturalOrder()));
    //
    //    Set<List<Integer>> set=new HashSet<>(res);
    //
    //    return new ArrayList<>(set);
    //}

    //private void dfs(int[] candidates, int target,int index,List<Integer> isSelected,List<List<Integer>> res){
    //
    //    if(target==0){
    //        res.add(new ArrayList<>(isSelected));
    //    }
    //    if(index==candidates.length){
    //        return;
    //    }
    ////   两种情况，当前index 位置的数据是否选择，如果不选择
    //    dfs(candidates,target,index+1,isSelected,res);
    //
    ////    如果选择，下一个也从index 开始，因为可以重复选择这个数字
    //    if(target-candidates[index]>=0){
    //        isSelected.add(candidates[index]);
    //
    //        dfs(candidates,target-candidates[index],index+1,isSelected,res);
    //
    //        //往前回溯一个位置
    //        isSelected.remove(isSelected.size()-1);
    //    }
    //}

    public static void main(String[] args) {
        int[] candidates=new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int target=27;
        System.out.println(JSON.toJSONString(new CombinationSum_40_组合总和2().combinationSum2(candidates,target)));

    }
}
