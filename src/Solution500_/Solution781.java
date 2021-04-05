package Solution500_;

import java.util.HashMap;
import java.util.Map;

public class Solution781 {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0)
            return 0;
        Map<Integer, Integer> countGroup = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            countGroup.put(answers[i], countGroup.getOrDefault(answers[i], 0) + 1);
        }

        int ret = 0;
        for(Integer key: countGroup.keySet()){
            ret += ((countGroup.get(key) - 1) / (key + 1)) * (key + 1) + key;
        }

        return ret;
    }
}
