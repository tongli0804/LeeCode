package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/14 22:45
 */
public class LongestPalindrome_5_最长回文子串 {

    //动态规划，序列是回文，则除去头尾的序列依然是回文
    public String longestPalindrome(String s) {
        int[][] indexIspalindrome=new int[s.length()][s.length()];
        int max=0;
        int maxStart=0;
        int maxEnd=0;
        if(s==null || s.length()==0){
            return "";
        }
        // 注意，i 是起始位置，j 是终止位置，因为动态规划需要起始位置+1，终止位置-1，需要确保起始位置+1 的已经运算过了
        for (int i = s.length()-1; i >=0; i--) {
            for (int j = i; j < s.length(); j++) {
                boolean found=false;
                if(i==j){
                    indexIspalindrome[i][j]=1;
                    found=true;
                }else if(s.charAt(i)==s.charAt(j)){
                    if (j-i==1 || indexIspalindrome[i+1][j-1]==1){
                        indexIspalindrome[i][j]=1;
                        found=true;
                    }

                }

                if(found && j-i+1>max){
                    max=j-i+1;
                    maxStart=i;
                    maxEnd=j;
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome_5_最长回文子串().longestPalindrome("babad"));
    }
}
