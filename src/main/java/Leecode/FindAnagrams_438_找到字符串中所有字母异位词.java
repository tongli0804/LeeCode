package Leecode;

import java.util.*;

/**
 * @author dylan.ll
 * @date 2022/3/5 17:16
 */
public class FindAnagrams_438_找到字符串中所有字母异位词 {
  /*  public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || p.length() > s.length()) {
            return res;
        }
        int pLen = p.length();
        //构造 HashMap 快速判断 异位词
        Map<Character,int[]> pMap = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            int[] count=pMap.get(p.charAt(i));
            if(count!=null){
                count[0]=count[0]+1;
                count[1]=count[1]+1;
            }else {
                pMap.put(p.charAt(i),new int[]{1,1});
            }
        }
        //窗口位置
        int slideWindowIndex = 0;
        //窗口内游标
        int cursorInWindow = 0;
        while (slideWindowIndex <= s.length() - pLen) {

            //重置map key count值
            pMap.values().forEach(count-> count[0]=count[1]);

            for (; cursorInWindow < pLen; cursorInWindow++) {

                char key = s.charAt(slideWindowIndex + cursorInWindow);
                if (!pMap.containsKey(key)) {
                    slideWindowIndex = slideWindowIndex + cursorInWindow + 1;
                    cursorInWindow = 0;
                    break;
                }else {
                    if(pMap.get(key)[0]==0){
                        slideWindowIndex++;
                        cursorInWindow=0;
                        break;
                    }else {
                        pMap.get(key)[0]=pMap.get(key)[0]-1;
                    }
                }
            }

            if (cursorInWindow == pLen) {
                res.add(slideWindowIndex);
                slideWindowIndex++;
                cursorInWindow=0;
            }

        }

        return res;

    }
*/

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || p.length() > s.length()) {
            return res;
        }
        int pLen = p.length();

        int[] pStatic=new int[26];
        int[] windowStatic=new int[26];
        for (int i = 0; i < pLen; i++) {
            pStatic[p.charAt(i)-'a']+=1;
            windowStatic[s.charAt(i)-'a']+=1;
        }
        if(Arrays.equals(pStatic,windowStatic)){
            res.add(0);
        }
        int left=0;
        int right=0;

       for (right=p.length();right<s.length();left++,right++){
           windowStatic[s.charAt(left)-'a']-=1;
           windowStatic[s.charAt(right)-'a']+=1;
           if(Arrays.equals(pStatic,windowStatic)){
               res.add(left+1);
           }
       }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(new FindAnagrams_438_找到字符串中所有字母异位词().findAnagrams("cbaebabacd","abc"));
    }

}
