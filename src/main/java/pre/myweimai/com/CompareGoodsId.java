package pre.myweimai.com;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class CompareGoodsId {
    public static void main(String[] args) {
        String path = "C:/Users/choice/Desktop/wenjian.txt";
        String writerpath = "C:/Users/choice/Desktop/wenjianxieru.txt";
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));//读取
            BufferedWriter bw = new BufferedWriter(new FileWriter(writerpath));//写入
            ArrayList<String> arrayList = new ArrayList<String>();
            String str;

            while ((str = in.readLine()) != null) {
                String[] s = str.split(", ");
                //System.out.println(Arrays.asList(s));
                for (int i=0;i< s.length;i++){
                    String b = s[i];
                    bw.write(s[i]+"\r\n");
                    //System.out.println(b);
                    bw.flush();

                }
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }


