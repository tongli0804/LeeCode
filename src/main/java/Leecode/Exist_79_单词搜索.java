package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/19 19:00
 */
public class Exist_79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = false;
                if (board[i][j] == word.charAt(0)) {
                    result = dfs(new int[] {i, j}, board, word, new int[board.length][board[0].length]);
                    if (result) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean dfs(int[] start, char[][] board, String word, int[][] visited) {
        if (word.length() == 1) {
            return word.charAt(0) == board[start[0]][start[1]];
        }
        visited[start[0]][start[1]] = 1;
        boolean result = false;
        if (start[0] - 1 >= 0 && board[start[0] - 1][start[1]] == word.charAt(1)
            && visited[start[0] - 1][start[1]] == 0) {
            result = dfs(new int[] {start[0] - 1, start[1]}, board, word.substring(1), visited);
        }
        if (!result && start[0] + 1 < board.length && board[start[0] + 1][start[1]] == word.charAt(1)
            && visited[start[0] + 1][start[1]] == 0) {
            result = dfs(new int[] {start[0] + 1, start[1]}, board, word.substring(1), visited);
        }
        if (!result && start[1] - 1 >= 0 && board[start[0]][start[1] - 1] == word.charAt(1)
            && visited[start[0]][start[1] - 1] == 0) {
            result = dfs(new int[] {start[0], start[1] - 1}, board, word.substring(1), visited);
        }
        if (!result && start[1] + 1 < board[0].length && board[start[0]][start[1] + 1] == word.charAt(1)
            && visited[start[0]][start[1] + 1] == 0) {
            result = dfs(new int[] {start[0], start[1] + 1}, board, word.substring(1), visited);
        }
        visited[start[0]][start[1]] = 0;
        return result;
    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word="ABCESEEEFS";
        System.out.println(new Exist_79_单词搜索().exist(board,word));
    }
}
