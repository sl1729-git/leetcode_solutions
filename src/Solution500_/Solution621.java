package Solution500_;

import java.util.HashMap;
import java.util.Map;

public class Solution621 {
    private int solution(char[] tasks, int n){
        assert n >= 0;
        if (tasks == null || tasks.length == 0)
            return 0;
        int ret = 0, count = 0, maxCountTask = 0;
        Map<Character, Integer> taskCount = new HashMap<>();
        for (char task:tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
        }
        char tmp = 0;
        for (Character key:taskCount.keySet()) {
            count = count > taskCount.get(key) ? count : taskCount.get(key);
        }
        for (Character key:taskCount.keySet()) {
            maxCountTask += taskCount.get(key) == count ? 1 : 0;
        }
        if (tasks.length <= count * (n+1)){
            return (count - 1) * (n+1) + maxCountTask +
                    ((tasks.length-maxCountTask*count > (count - 1) * (n-maxCountTask+1)) ?
                            tasks.length-maxCountTask*count - (count - 1) * (n-maxCountTask+1) : 0);
        }else {
            return tasks.length;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        return solution(tasks, n);
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
    }
}
