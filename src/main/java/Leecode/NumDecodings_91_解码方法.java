package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/19 23:00
 */
public class NumDecodings_91_解码方法 {
    public int numDecodings(String s) {
        if(s.startsWith("0")){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int[] dp=new int[s.length()];
        dp[0]=1;
        if(isVaild(s.substring(1,2))){
            //两位数是否有效
            if(isVaild(s.substring(0,2))){
                dp[1]=2;
            }else {
                dp[1]=1;
            }
        }else {
            //两位数是否有效
            if(isVaild(s.substring(0,2))){
                dp[1]=1;
            }else {
                return 0;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            if(isVaild(s.substring(i,i+1))){
                //两位数是否有效
                if(isVaild(s.substring(i-1,i+1))){
                    dp[i]=dp[i-1]+dp[i-2];
                }else {
                    dp[i]=dp[i-1];
                }
            }else {
                //两位数是否有效
                if(isVaild(s.substring(i-1,i+1))){
                    dp[i-1]=dp[i-2];
                    dp[i]=dp[i-1];
                }else {
                    return 0;
                }
            }
        }

        return dp[s.length()-1];
    }
    private boolean isVaild(String str){
        if(str.length()==1){
           return !"0".equals(str);
        }else if (str.length()==2){
            return Integer.parseInt(str)<=26 && Integer.parseInt(str)>9;
        }else {
            throw new RuntimeException("error");
        }
    }


    public static void main(String[] args) {
       System.out.println( new NumDecodings_91_解码方法().numDecodings("2101"));
    }
}
