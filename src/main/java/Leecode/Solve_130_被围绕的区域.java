package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author dylan.ll
 * @date 2022/3/9 22:28
 */
public class Solve_130_被围绕的区域 {

    private static char FLAG_O = 'O';

    public void solve(char[][] board) {
        Set<Node> notVisited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == FLAG_O) {
                    Node node = new Node(i, j);
                    notVisited.add(node);
                }
            }
        }
        while (!notVisited.isEmpty()) {
            Node cur = notVisited.stream().findAny().get();
            Queue<Node> queue = new ArrayDeque<>();
            List<Node> visted = new ArrayList<>();
            boolean isBorder = visitNext(cur, board, queue, notVisited, visted);
            while (!queue.isEmpty()) {
                cur = queue.poll();
                //   上下左右
                Node next = new Node(cur.firstIndex - 1, cur.secondIndex);
                isBorder = visitNext(next, board, queue, notVisited, visted) || isBorder;

                next = new Node(cur.firstIndex + 1, cur.secondIndex);
                isBorder = visitNext(next, board, queue, notVisited, visted) || isBorder;

                next = new Node(cur.firstIndex, cur.secondIndex - 1);
                isBorder = visitNext(next, board, queue, notVisited, visted) || isBorder;

                next = new Node(cur.firstIndex, cur.secondIndex + 1);
                isBorder = visitNext(next, board, queue, notVisited, visted) || isBorder;
            }

            if (!isBorder) {
                visted.forEach(node -> board[node.firstIndex][node.secondIndex] = 'X');
            }
        }

    }

    private boolean visitNext(Node next, char[][] board, Queue<Node> queue, Set<Node> notVisited, List<Node> visted) {
        if (next.firstIndex >= 0 && next.firstIndex < board.length && next.secondIndex >= 0
            && next.secondIndex < board[0].length && board[next.firstIndex][next.secondIndex] == FLAG_O
            && notVisited.contains(next)) {
            visted.add(next);
            notVisited.remove(next);
            queue.add(next);
            return next.firstIndex == 0 || next.firstIndex == board.length - 1 || next.secondIndex == 0
                || next.secondIndex == board[0].length - 1;
        }

        return false;

    }

    static class Node {
        int firstIndex;
        int secondIndex;

        public Node(int firstIndex, int secondIndex) {
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (o == null || getClass() != o.getClass()) {return false;}
            Node node = (Node)o;
            return firstIndex == node.firstIndex && secondIndex == node.secondIndex;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + firstIndex;
            result = 31 * result + secondIndex;
            return result;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'O'},
            {'O', 'X', 'O', 'O', 'O', 'O'}};
        new Solve_130_被围绕的区域().solve(board);

        System.out.println(JSON.toJSONString(board));
    }
}
