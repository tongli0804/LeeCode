package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dylan.ll
 * @date 2022/3/21 23:24
 */
public class GetAncestors_2192_有向无环图中一个节点的所有祖先 {
    //    有向无环图，找到入度为0 节点，dijstra 一次，得到路径即可，
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[][] matrix = new int[n][n];
        boolean[] isInVer = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
            }
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = 1;
            isInVer[edges[i][1]] = true;
        }

        for (int i = 0; i < matrix.length; i++) {

            if (!isInVer[i]) {
                int[] path = dijstra(matrix, i);
                for (int j = 0; j < path.length; j++) {
                    res.get(j).addAll(getAnceByPath(path, i, j));
                }
            }
        }
        return res;
    }

    private List<Integer> getAnceByPath(int[] path, int start, int index) {
        List<Integer> res = new ArrayList<>();
        if (path[index] == -1 || index == start) {
            return res;
        }
        int cur = index;
        while (cur != start) {
            res.add(path[cur]);
            cur = path[cur];
        }
        return res;
    }

    private int[] dijstra(int[][] matrix, int start) {
        int[] dis = new int[matrix.length];
        int[] path = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            dis[i] = Integer.MAX_VALUE;
            path[i] = -1;
        }
        dis[start] = 0;
        path[start] = -1;
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, start));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(dis[cur.index]<cur.dis){
                continue;
            }

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[cur.index][i] < dis[i]) {
                    path[i] = cur.index;
                    dis[i] = matrix[cur.index][i];
                    queue.add(new Node(i, dis[i]));
                }
            }
        }

        return path;
    }

    static class Node implements Comparable<Node> {
        int dis;
        int index;

        public Node(int dis, int index) {
            this.dis = dis;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return o.dis - this.dis;
        }
    }

    public static void main(String[] args) {
        int n=5;
        int[][] edges={{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}};
        System.out.println(JSON.toJSONString(new GetAncestors_2192_有向无环图中一个节点的所有祖先().getAncestors(n,edges)));
    }
}
