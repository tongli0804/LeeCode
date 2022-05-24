package Leecode;

/**
 * @author dylan.ll
 * @date 2022/4/17 20:52
 */
public class DigitSum_6070_计算字符串的数字和 {
    public String digitSum(String s, int k) {
        if(s==null || s.length()<=k){
            return s;
        }
        StringBuilder stringBuilder=new StringBuilder();

        for (int i = 0; i < s.length() ; ) {
            int sum=0;
            for (int j = 0; j < k && i < s.length(); i++,j++) {
                sum+=Integer.parseInt(s.charAt(i)+"");
            }
            stringBuilder.append(sum);
        }
        return digitSum(stringBuilder.toString(),k);
    }

    public static void main(String[] args) {
        System.out.println(new DigitSum_6070_计算字符串的数字和().digitSum("00000000",3));
    }
}
