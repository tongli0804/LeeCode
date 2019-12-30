package pre.myweimai.com;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CompareGoodsId {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:/Users/choice/Desktop/wenjian.txt"));
            String str;

            while ((str = in.readLine()) != null) {
                String[] s = str.split(", ");
                System.out.println(s);
            }
            System.out.println(str);
        } catch (IOException e) {
        }
    }

    }


