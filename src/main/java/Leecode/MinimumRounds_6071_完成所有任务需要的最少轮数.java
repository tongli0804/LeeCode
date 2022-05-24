package Leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dylan.ll
 * @date 2022/4/17 21:05
 */
public class MinimumRounds_6071_完成所有任务需要的最少轮数 {
    public int minimumRounds(int[] tasks) {
        if(tasks==null || tasks.length==0){
            return 0;
        }
        Map<Integer,Integer> taskCount=new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            taskCount.put(tasks[i],taskCount.getOrDefault(tasks[i],0)+1);
        }
        int minCoun=0;
        for (Integer count:taskCount.values()){
            if(count%3==0){
                minCoun+=count/3;
            }else if(count>=2 &&  (count-2)%3==0){
                minCoun+=(count-2)/3+1;
            }
            else if(count>=4 &&(count-4)%3==0){
                minCoun+=(count-4)/3+2;
            }
            else if(count%2==0){
                minCoun+=count/2;
            }else {
                return -1;
            }
        }
        return minCoun;

    }

    public static void main(String[] args) {
      //int[] tasks=  {66,66,63,61,63,63,64,66,66,65,66,65,61,67,68,66,62,67,61,64,66,60,69,66,65,68,63,60,67,62,68,60,66,64,60,60,60,62,66,64,63,65,60,69,63,68,68,69,68,61};
        int[] tasks={2,3,3};
            System.out.println(new MinimumRounds_6071_完成所有任务需要的最少轮数().minimumRounds(tasks));
    }

}
