package helper;

import java.io.*;

/**
 * @author dylan.ll
 * @date 2019-11-01 11:55
 */
public class CodeConvert {


    public String read(File file) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
        StringBuilder context = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            context.append(line).append("\n");
        }
        br.close();
        return context.toString();
    }

    public void write(File file, String context) throws Exception {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();

        PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8")));
        out.write(context);
        out.flush();
        out.close();
    }

    public void traverseFolder2(String path) throws Exception {

        File file = new File(path);
        if (file.exists()) {
            if (!file.isDirectory()){
                if (file.getName().endsWith(".java")) {
                    System.out.println("文件:" + file.getAbsolutePath());
                    write(file, read(file));
                }
            }

            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        //System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        if (file2.getName().endsWith(".java")) {
                            System.out.println("文件:" + file2.getAbsolutePath());
                            //if("GBK".equals(codeString(file2))){
                            //    System.out.println("文件:" + file2.getAbsolutePath()+",endcoding"+codeString(file2));
                            write(file2, read(file2));
                            //}

                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
    //public static String codeString(File file) throws Exception {
    //    BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
    //    int p = (bin.read() << 8) + bin.read();
    //    bin.close();
    //    String code = null;
    //    System.out.println(p);
    //    switch (p) {
    //        case 0xefbb:
    //            code = "UTF-8";
    //            break;
    //        case 0xfffe:
    //            code = "Unicode";
    //            break;
    //        case 0xfeff:
    //            code = "UTF-16BE";
    //            break;
    //        default:
    //            code = "GBK";
    //    }
    //
    //    return code;
    //}
    public static void main(String[] args) {
        String path = "/Users/dylan.ll/Documents/projects/warehousecenter/whc-ext";
        CodeConvert codeConvert = new CodeConvert();
        try {
            codeConvert.traverseFolder2(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
