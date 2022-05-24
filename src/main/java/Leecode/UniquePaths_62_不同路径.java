package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/19 22:11
 */
public class UniquePaths_62_不同路径 {
    public int uniquePaths(int m, int n) {
    //    动态规划，一个点（i，j） 肯定是由 （i-1，j） 或者 （i，j-1） 过来的，则方案数等于两个相加
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if(i==0 || j==0){
                    dp[i][j]=1;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    //直接dfs 会超时
    int count=0;
    private void dfs(int curX,int curY,int m,int n){
        if(curX==m-1 && curY==n-1){
            count++;
            return;
        }
        if(curX>m-1 || curY>n-1){
            return;
        }
        dfs(curX+1, curY, m, n);

        dfs( curX, curY+1, m, n);
    }
}
