package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author dylan.ll
 * @date 2022/3/10 21:33
 */
public class AllPathsSourceTarget_797_所有可能的路径 {

    //public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    //    List<List<Integer>> res=new ArrayList<>();
    //    Stack<Node> stack=new Stack<>();
    //    int target=graph.length-1;
    //    stack.push(new Node(0,0));
    //    while (!stack.isEmpty()){
    //        Node cur= stack.peek();
    //        if(cur.vertexIndex==target){
    //            List<Integer> path=stack.stream().map(Node::getVertexIndex).collect(Collectors.toList());
    //            res.add(path);
    //            stack.pop();
    //            continue;
    //        }
    //        if(cur.edge>graph[cur.vertexIndex].length-1){
    //            stack.pop();
    //            continue;
    //        }
    //
    //        stack.push(new Node(graph[cur.vertexIndex][cur.edge++],0));
    //    }
    //    return res;
    //}


        List<List<Integer>> res=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        stack.push(0);
        dfs(graph,0,graph.length-1);
        return res;
    }
    public void dfs(int[][] graph ,int cur,int target){
        if(cur==target){
            res.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < graph[cur].length; i++) {
            stack.push(graph[cur][i]);
            dfs(graph,graph[cur][i],target);
            stack.pop();
        }
    }

    static class Node {
        int vertexIndex;
        int edge;

        public Node(int vertexIndex, int edge) {
            this.vertexIndex = vertexIndex;
            this.edge = edge;
        }

        public int getVertexIndex() {
            return vertexIndex;
        }

        public int getEdge() {
            return edge;
        }
    }

    public static void main(String[] args) {
    }
}
