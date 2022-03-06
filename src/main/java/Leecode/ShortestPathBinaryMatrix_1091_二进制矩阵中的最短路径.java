package Leecode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author dylan.ll
 * @date 2022/3/6 21:56
 */
public class ShortestPathBinaryMatrix_1091_二进制矩阵中的最短路径 {

    // BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;

        Queue<int[]> queue = new ArrayDeque();
        int[][] dis = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dis[i][j] = -1;
            }
        }

        if (grid[0][0] == 0) {
            queue.add(new int[] {0, 0});
            dis[0][0] = 1;
        }

        boolean isEnd=false;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int path=dis[cur[0]][cur[1]]+1;
            //前后左右对角
            int[] next = new int[] {cur[0] - 1, cur[1]};
            isEnd=isEnd || visitNext(grid, length, queue, dis, path, next);

            next = new int[] {cur[0] + 1, cur[1]};
            isEnd=isEnd ||visitNext(grid, length, queue, dis, path, next);

            next = new int[] {cur[0], cur[1] - 1};
            isEnd=isEnd || visitNext(grid, length, queue, dis, path, next);

            next = new int[] {cur[0], cur[1] + 1};
            isEnd=isEnd ||visitNext(grid, length, queue, dis, path, next);

            next = new int[] {cur[0] - 1, cur[1] - 1};
            isEnd=isEnd ||visitNext(grid, length, queue, dis, path, next);

            next = new int[] {cur[0] - 1, cur[1] + 1};
            isEnd=isEnd ||visitNext(grid, length, queue, dis, path, next);

            next = new int[] {cur[0] + 1, cur[1] - 1};
            isEnd=isEnd ||visitNext(grid, length, queue, dis, path, next);

            next = new int[] {cur[0] + 1, cur[1] + 1};
            isEnd=isEnd ||visitNext(grid, length, queue, dis, path, next);
            if(isEnd){
                return dis[length-1][length-1];
            }

        }
        return dis[length-1][length-1];
    }


    private boolean visitNext(int[][] grid, int length, Queue<int[]> queue, int[][] dis, int path, int[] next) {
        if (next[0] >= 0 && next[0] < length && next[1] >= 0 && next[1] < length && grid[next[0]][next[1]] == 0
            && dis[next[0]][next[1]] == -1) {
            queue.add(new int[] {next[0], next[1]});
            dis[next[0]][next[1]] = path;
            return next[0]==length-1 && next[1]==length-1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] grid={{0,0,0},{1,1,0},{1,1,0}};

        System.out.println(new ShortestPathBinaryMatrix_1091_二进制矩阵中的最短路径().shortestPathBinaryMatrix(grid));
    }

}
