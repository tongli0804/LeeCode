package Leecode;

import java.util.*;

/**
 * @author dylan.ll
 * @date 2022/3/20 19:42
 */
public class WordBreak_139_单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet=new HashSet<>(wordDict);
        return dfs(s,wordSet);
    }
    private Map<String,Boolean> CACHE=new HashMap<>();
    //直接dfs 会超时，加入缓存，避免重复计算
    private boolean dfs(String s, Set<String> wordDict){
        if(s==null || s.length()==0){
            return true;
        }
        if(CACHE.containsKey(s)){
            return CACHE.get(s);
        }
        //字典中的单词最长20
        for (int i = 0; i < s.length() && i<20; i++) {
            if(wordDict.contains(s.substring(0,i+1))){
                //如果最后了，则直接返回，避免下一步s.substring(i+1) 报错
                if(i==s.length()-1){
                    CACHE.put(s.substring(0,i+1),true);
                    return true;
                }
                boolean res=dfs(s.substring(i+1),wordDict);
                CACHE.put(s.substring(i+1),res);
                if(res){
                    return true;
                }
            }
        }

        return false;
    }

}
