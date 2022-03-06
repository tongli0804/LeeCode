package Leecode;

import java.util.*;

/**
 * @author dylan.ll
 * @date 2022/3/5 23:01
 */
public class NumIslands_200_岛屿数量 {
    public int numIslands(char[][] grid) {
        int res=0;
        Set<String> noVisitNodeMap=new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    noVisitNodeMap.add(getIndexKey(new int[]{i,j}));
                }
            }
        }
        while (!noVisitNodeMap.isEmpty()){
            res++;
           int[] root= parseIndexKey(noVisitNodeMap.stream().findFirst().get());
           visitTree(root,grid,noVisitNodeMap);
        }
        return res;
    }

    private void visitTree(int[] root,char[][] grid,Set<String> noVisistNodes){
        if(root==null){
            return;
        }
        noVisistNodes.remove(getIndexKey(root));
        int[] nextIndex=new int[]{root[0]-1,root[1]};
        if(nextIndex[0] >= 0 && grid[nextIndex[0]][nextIndex[1]]=='1'){
            grid[nextIndex[0]][nextIndex[1]]='0';
            visitTree(nextIndex,grid,noVisistNodes);
        }

        nextIndex=new int[]{root[0]+1,root[1]};
        if(nextIndex[0] < grid.length && grid[nextIndex[0]][nextIndex[1]]=='1' ){
            grid[nextIndex[0]][nextIndex[1]]='0';
            visitTree(nextIndex,grid,noVisistNodes);
        }
        nextIndex=new int[]{root[0],root[1]-1};
        if(nextIndex[1] >= 0 && grid[nextIndex[0]][nextIndex[1]]=='1' ){
            grid[nextIndex[0]][nextIndex[1]]='0';
            visitTree(nextIndex,grid,noVisistNodes);
        }
        nextIndex=new int[]{root[0],root[1]+1};
        if(nextIndex[1] < grid[0].length && grid[nextIndex[0]][nextIndex[1]]=='1'){
            grid[nextIndex[0]][nextIndex[1]]='0';
            visitTree(nextIndex,grid,noVisistNodes);
        }

    }

    private String getIndexKey(int[] root) {
        return root[0] + "#" + root[1];
    }

    private int[] parseIndexKey(String key) {
        return new int[]{Integer.parseInt(key.split("#")[0]),Integer.parseInt(key.split("#")[1])};
    }

    public static void main(String[] args) {
        char[][] grid={{'1','0','1','1','0','1','1'}};
        System.out.println(new NumIslands_200_岛屿数量().numIslands(grid));
    }

}
