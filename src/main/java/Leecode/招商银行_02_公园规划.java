package Leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dylan.ll
 * @date 2022/4/16 17:45
 */
public class 招商银行_02_公园规划 {
    public int numFlowers(int[][] roads) {
        List<Set<Integer>> ver=new ArrayList<>();
        for (int i = 0; i < roads.length; i++) {
            while (ver.size()<=roads[i][0]){
                ver.add(new HashSet<>());
            }
            while (ver.size()<=roads[i][1]){
                ver.add(new HashSet<>());
            }
            ver.get(roads[i][0]).add(roads[i][1]);
            ver.get(roads[i][1]).add(roads[i][0]);
        }
        int max= 0;
        for (int i = 0; i < ver.size(); i++) {
            Set<Integer> curConSet=ver.get(i);
            Set<Integer> conCount=new HashSet<>(curConSet);
            conCount.add(i);
            for (int nextVer:curConSet){
                conCount.addAll(ver.get(nextVer));
            }
            if(conCount.size()>max){
                max=conCount.size();
            }
        }

        return max;
    }
    public static void main(String[] args) {
        //int[][] roads={{0,1},{1,3},{1,2}};
        //System.out.println(new 招商银行_02_公园规划().numFlowers(roads));
        int[][] roads={{0,1},{0,2},{1,3},{2,5},{3,6},{5,4}};
        System.out.println(new 招商银行_02_公园规划().numFlowers(roads));
    }
}
