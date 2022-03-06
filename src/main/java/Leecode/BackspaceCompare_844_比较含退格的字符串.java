package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/5 12:16
 */
public class BackspaceCompare_844_比较含退格的字符串 {
    public boolean backspaceCompare(String s, String t) {
        int firstIndex = s.length() - 1;
        int secIndex = t.length() - 1;

        while (firstIndex >= 0 && secIndex >= 0) {
            firstIndex = getNextIndex(s, firstIndex);
            secIndex = getNextIndex(t, secIndex);
            if (firstIndex == -1 || secIndex==-1) {
                return getNextIndex(s,firstIndex)==getNextIndex(t,secIndex);
            }
            if(s.charAt(firstIndex)==t.charAt(secIndex)){
                firstIndex--;
                secIndex--;
            }else {
                return false;
            }

        }
        return getNextIndex(s,firstIndex)==getNextIndex(t,secIndex);
    }

    private int getNextIndex(String s, int index) {
        int countDel = 0;
        while (index >= 0) {
            if (s.charAt(index) == '#') {
                countDel++;
            } else if (countDel == 0) {
                return index;
            } else {
                countDel--;
            }
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceCompare_844_比较含退格的字符串().backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }

}
