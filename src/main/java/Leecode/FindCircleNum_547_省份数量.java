package Leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dylan.ll
 * @date 2022/3/6 16:07
 */
public class FindCircleNum_547_省份数量 {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected.length==0){
            return 0;
        }
        int res=0;
        Set<Integer> noVisitNodeMap=new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            noVisitNodeMap.add(i);
        }
        while (!noVisitNodeMap.isEmpty()){
            res++;
            int root= noVisitNodeMap.stream().findFirst().get();
            visitTree(root,isConnected,noVisitNodeMap);
        }
        return res;
    }

    private void visitTree(int root, int[][] isConnected, Set<Integer> noVisistNodes){

        noVisistNodes.remove(root);
        for (int i = 0; i < isConnected.length; i++) {
            if(i!=root && isConnected[root][i]==1 && noVisistNodes.contains(i)){
                isConnected[root][i]=0;
                visitTree(i,isConnected,noVisistNodes);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected={{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(new FindCircleNum_547_省份数量().findCircleNum(isConnected));
    }
}
