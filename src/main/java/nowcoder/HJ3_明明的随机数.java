package nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author dylan.ll
 * @date 2022/3/26 15:32
 */
public class HJ3_明明的随机数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=in.nextInt();
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        set.stream().sorted().forEach(System.out::println);
    }
}
