package Leecode;

import java.util.*;

/**
 * @author dylan.ll
 * @date 2022/1/16 15:31
 * 时间复杂度 E*V 每条边遍历V-1 次
 */
public class Bellman_Frod_743_网络延迟时间 {

    public int networkDelayTime(int[][] times, int n, int k) {

        if (times == null || times.length == 0) {
            return -1;
        }

        //记录起始点到当前点的距离
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE/2);

        dis[k]=0;

        //每个边遍历n-1 次，n 是节点数量，因为最大路径最多经过n-1 条边，不然成成环
        for (int i=1;i< n;i++){
            //标记这次有没有更新路径的松弛操作，如果没有，则表示遍历完了，或者没有可达了
            boolean flag=false;
            for (int[] time : times) {
                int tmpDis = dis[time[0]] + time[2];
                if (dis[time[1]] > tmpDis) {
                    dis[time[1]] = tmpDis;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }

        boolean flag=false;
        for (int[] time : times) {
            int tmpDis = dis[time[0]] + time[2];
            if (dis[time[1]] > tmpDis) {
                dis[time[1]] = tmpDis;
                flag=true;
                break;
            }
        }
        //存在负路径环
        if(flag){
            return -1;
        }

        int max=0;
        for (int i = 1; i < n+1; i++) {
            if(max<dis[i]){
                max=dis[i];
            }
        }
        if(max>=Integer.MAX_VALUE/2){
            return -1;
        }
        return max;

    }

    public static void main(String[] args) {
        int[][] times={{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
        int n=5,k=5;
        //int[][] times={{2,1,1},{2,3,1},{3,4,1}};
        //int n=4,k=2;

        System.out.println(new Bellman_Frod_743_网络延迟时间().networkDelayTime(times,n,k));

        //System.out.println(Integer.MAX_VALUE+10);
    }
}
