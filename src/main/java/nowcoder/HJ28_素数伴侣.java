package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dylan.ll
 * @date 2022/3/26 15:41
 */
public class HJ28_素数伴侣 {
    static List<Integer> oddList;
    static List<Integer> evenList;
    static int[] evenMatch;
    static int[][] verMatix;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            // 注意 hasNext 和 hasNextLine 的区别
            int n=in.nextInt();
            oddList=new ArrayList<>();
            evenList=new ArrayList<>();
            //int[] nums= Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < n; i++) {
                int cur=in.nextInt();
                if(cur % 2 ==0){
                    evenList.add(cur);
                }else {
                    oddList.add(cur);
                }
            }

            evenMatch=new int[evenList.size()];

            verMatix=new int[oddList.size()][evenList.size()];

            for (int i = 0; i < oddList.size(); i++) {
                for (int j = 0; j < evenList.size(); j++) {
                    if(isPrime(oddList.get(i)+evenList.get(j))){
                        verMatix[i][j]=1;
                    }
                }
            }

            for (int i = 0; i < evenList.size(); i++) {
                evenMatch[i]=-1;
            }
            for (int i = 0; i < oddList.size(); i++) {
                match(i,new boolean[evenMatch.length]);
            }
            int count=0;
            for (int i = 0; i < evenMatch.length; i++) {
                if(evenMatch[i]>=0){
                    count++;
                }
            }
            System.out.println(count);

        }

    }


    private static boolean match(int i,boolean[] used){
        for (int j = 0; j < evenList.size(); j++) {
            if(verMatix[i][j]==1 && !used[j] && evenMatch[j]==-1){
                used[j]=true;
                evenMatch[j]=i;
                return true;
            }
        }

        for (int j = 0; j < evenList.size(); j++) {
            if(verMatix[i][j]==1 && !used[j]){
                used[j]=true;
                if(match(evenMatch[j],used)){
                    evenMatch[j]=i;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int x) {
        if (x == 1 || x % 2 == 0 && x != 2) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(x); i += 2) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
