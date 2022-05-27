package Solution500_;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1723 {
    public int minimumTimeRequired(int[] jobs, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k * 2);
        Arrays.sort(jobs);
        for (int i = 1; i <= k; i++) {
            queue.add(jobs[jobs.length - i]);
        }
        for (int i = jobs.length - 1 - k; i >= 0; i--) {
            int tmp = queue.poll();
            queue.add(tmp + jobs[i]);
        }

        int ret = queue.stream().mapToInt(Integer::valueOf).max().getAsInt();

        return ret;
    }

    public static void main(String[] args) {
        int[] jobs = new int[]{5,5,4,4,4};
        Solution1723 s = new Solution1723();
        System.out.println(s.minimumTimeRequired(jobs, 2));
    }
}
