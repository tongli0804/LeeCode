package Leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dylan.ll
 * @date 2022/3/13 22:14
 */
public class LetterCombinations_17_电话号码的字母组合 {

    List<List<Character>> model = new ArrayList<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return Collections.emptyList();
        }
        int count = 0;
        for (int i = 0; i < 8; i++) {
            List<Character> curChaList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                curChaList.add((char)('a' + count++));
            }
            if (i == 5 || i == 7) {
                curChaList.add((char)('a' + count++));
            }
            model.add(curChaList);
        }
        dfs(digits, 0, new ArrayList<>());
        return result;
    }

    private void dfs(String digits, int index, List<Character> mean) {
        if (index >= digits.length()) {
            if (!mean.isEmpty()) {
                result.add(getStr(mean));
            }
            return;
        }
        for (Character character : model.get(digits.charAt(index) - '2')) {
            mean.add(character);
            dfs(digits, index + 1, mean);
            mean.remove(mean.size() - 1);
        }
    }

    private String getStr(List<Character> mean) {
        StringBuilder str = new StringBuilder();
        mean.forEach(str::append);
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations_17_电话号码的字母组合().letterCombinations("23"));
    }
}
