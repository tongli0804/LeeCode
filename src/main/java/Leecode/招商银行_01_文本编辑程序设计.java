package Leecode;

/**
 * @author dylan.ll
 * @date 2022/4/16 17:45
 */
public class 招商银行_01_文本编辑程序设计 {
    public String deleteText(String article, int index) {
        if(article.charAt(index)==' '){
            return article;
        }
        int start=index;
        while (start>0 && article.charAt(start)!=' '){
            start--;
        }
        if(article.charAt(start)==' '){
            start++;
        }

        int end=index;
        while (end<article.length() && article.charAt(end)!=' '){
            end++;
        }

        article=article.substring(0,start)+article.substring(end);
        int size=-1;
        while (size!=article.length()){
            article=article.replace("  "," ");
            size=article.length();
        }
        return article.trim();

    }

    public static void main(String[] args) {
        System.out.println(new 招商银行_01_文本编辑程序设计().deleteText("e RSg c R cf",
            10));
        System.out.println(new 招商银行_01_文本编辑程序设计().deleteText("Singing dancing in the rain",
            10));
    }
}
