package Solution100_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> map = new HashMap<>();
        wordDict.sort(String::compareTo);
        String tmp;
        for (int i = 0; i < wordDict.size(); i++) {
            tmp = wordDict.get(i);
            if (map.containsKey(tmp.charAt(0)))
                map.get(tmp.charAt(0)).add(tmp);
            else {
                map.put(tmp.charAt(0), new ArrayList<>());
                map.get(tmp.charAt(0)).add(tmp);
            }
        }
        return null;

    }
}
