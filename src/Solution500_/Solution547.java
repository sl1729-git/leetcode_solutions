package Solution500_;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution547 {

    private void search(int[] group, int[][] isConnected, Queue<Integer> queue, int index){
        int currentCity;
        while (!queue.isEmpty()){
            currentCity = queue.poll();
            for (int i = 0; i < isConnected[currentCity].length; i++) {
                if (group[i] == 0 && isConnected[currentCity][i] == 1){
                    group[i] = index;
                    queue.add(i);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0)
            return 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int[] group = new int[isConnected.length];
        Arrays.fill(group,0);
        int index = 1, currentCity = -1;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == 0){
                queue.add(i);
                group[i] = index;
                search(group, isConnected, queue, index++);
            }
        }
        return index-1;
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                {1,1,0},{1,1,0},{0,0,1}
        };
        Solution547 s= new Solution547();
        System.out.println(s.findCircleNum(isConnected));
    }
}
