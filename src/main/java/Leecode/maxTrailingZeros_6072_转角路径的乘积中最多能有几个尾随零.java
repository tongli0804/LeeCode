package Leecode;

/**
 * @author dylan.ll
 * @date 2022/4/17 21:39
 */
public class maxTrailingZeros_6072_转角路径的乘积中最多能有几个尾随零 {

    public int maxTrailingZeros(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int[][] forPos=new int[m][n];
        int[][] forRes=new int[m][n];
        forPos[0][0]=grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j==0){
                    forPos[i][i] =
                }
                forPos[i][i] = grid[i][j]*
            }
        }
    }
}
