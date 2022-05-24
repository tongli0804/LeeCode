package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/18 22:10
 */
public class LongestCommonSubsequence_1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int max = 0;
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {

                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence_1143_最长公共子序列().longestCommonSubsequence("abcde","ace"));
    }
}
