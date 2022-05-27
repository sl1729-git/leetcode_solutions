package Solution151_300;

import Test.Query;

import java.util.*;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        assert numCourses >= 0;
        int[] preIn = new int[numCourses];
        Map<Integer, List<Integer>> edge = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            preIn[prerequisites[i][0]]++;
            if (edge.containsKey(prerequisites[i][0])){
                edge.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else {
                edge.put(prerequisites[i][1],new ArrayList<>(Arrays.asList(prerequisites[i][0])));
            }
        }

        int[] ret = new int[numCourses];
        int count = 0, loop = 0;
        while (count < numCourses && loop < numCourses){
            for (int i = 0; i < preIn.length; i++) {
                if (preIn[i] == 0){
                    ret[count++] = i;
                    if (edge.containsKey(i)){
                        for (Integer edgeIn:edge.get(i)) {
                            preIn[edgeIn]--;
                        }
                    }

                }
            }
            loop ++;
        }

        return ret;
    }

    public int[] solution(int numCourses, int[][] prerequisites){
        Queue<P> pQueue = new PriorityQueue<>(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return Integer.compare(o1.in.size() * (2 << 16) + o1.node, o2.in.size() * (2 << 16) + o2.node);
            }
        });

        List<P> ps = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            ps.add(new P(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            ps.get(i).in.add(prerequisites[i][1]);
        }

        pQueue.addAll(ps);
        int[] ret = new int[numCourses];
        int count = 0;
        while (!pQueue.isEmpty()){

            P currentClass = pQueue.poll();
            if (currentClass.in.size() == 0){
                ret[count ++] = currentClass.node;
                for (P p:pQueue) {
                    p.in.remove(currentClass.node);
                }
            }
        }
        return null;
    }

    public int[] solution2(int numCourses, int[][] prerequisites){
        Queue<Integer> queue = new ArrayDeque<>();
        int[] in = new int[numCourses];
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int[] edge:prerequisites) {
            if (edges.containsKey(edge[1]))
                edges.get(edge[1]).add(edge[0]);
            else
                edges.put(edge[1], new HashSet<>(Arrays.asList(edge[0])));
            in[edge[0]]++;
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0)
                queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()){
            int currentNode = queue.poll();
            in[count ++] = currentNode;
            if (edges.containsKey(currentNode)){
                for (Integer node:edges.get(currentNode)) {
                    in[node]--;
                    if (in[node] == 0) {
                        queue.add(node);
                        edges.remove(node);
                    }
                }
            }

        }

        return in;
    }
}

class P{
    int node;
    Set<Integer> in = new HashSet<>();

    public P(int node){
        this.node = node;
    }
}
